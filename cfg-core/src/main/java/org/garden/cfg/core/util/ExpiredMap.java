package org.garden.cfg.core.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class ExpiredMap<K, V> implements Map<K, V> {

	/**
	 * 每隔period检测一次过期的键值对（单位：毫秒）
	 */
	private long period = 60000;

	/**
	 * 默认过期时间（单位：毫秒）
	 */
	private long defaultExpireTime = 360000;

	private Map<K, V> map = new ConcurrentHashMap<K, V>();

	private Map<K, ExpireInfo> expireInfoMap = new ConcurrentHashMap<K, ExpireInfo>();

	private ExpiredDaemonTimer daemonTimer = new ExpiredDaemonTimer();

	public ExpiredMap() {
		startTimer();
	}

	public ExpiredMap(long period) {
		this.period = period;
		startTimer();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		boolean containsKey = map.containsKey(key);
		if (containsKey) {
			refreshKey(key);
		}
		return containsKey;
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public V get(Object key) {
		refreshKey(key);
		return map.get(key);
	}

	@Override
	public V put(K key, V value) {
		return put(key, value, defaultExpireTime);
	}

	public V put(K key, V value, long expireTime) {
		expireInfoMap.put(key, new ExpireInfo(expireTime));
		return map.put(key, value);
	}

	@Override
	public V remove(Object key) {
		expireInfoMap.remove(key);
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		putAll(m, defaultExpireTime);
	}

	public void putAll(Map<? extends K, ? extends V> m, long expireTime) {
		for (K key : m.keySet()) {
			expireInfoMap.put(key, new ExpireInfo(expireTime));
		}
		map.putAll(m);
	}

	@Override
	public void clear() {
		expireInfoMap.clear();
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return map.entrySet();
	}

	public void refreshKey(Object key) {
		if (key != null) {
			ExpireInfo expireInfo = expireInfoMap.get(key);
			if (expireInfo != null && expireInfo.expireTime != null) {
				expireInfo.refresh();
			}
		}
	}

	private void startTimer() {
		daemonTimer.start();
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	class ExpireInfo {
		/**
		 * 过期时间
		 */
		Long expireTime;
		/**
		 * 到期时间
		 */
		Long deadlineTime;

		public ExpireInfo() {
			this.expireTime = defaultExpireTime;
		}

		public ExpireInfo(long expireTime) {
			setExpireTime(expireTime);
		}

		public void refresh() {
			this.deadlineTime = System.currentTimeMillis() + expireTime;
		}

		public void setExpireTime(Long expireTime) {
			this.expireTime = expireTime;
			refresh();
		}

	}

	class ExpiredDaemonTimer {
		private Timer timer = new Timer("expiredMap-" + this.hashCode(), true);

		public void start() {
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					if (map.isEmpty() || expireInfoMap.isEmpty()) {
						return;
					}
					expireInfoMap.forEach((k, v) -> {
						if (v != null && v.deadlineTime != null && v.deadlineTime < System.currentTimeMillis()) {
							remove(k);
						}
					});
				}
			}, 0, period);
		}

	}

}

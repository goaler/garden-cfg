package org.garden.cfg.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.garden.cfg.controller.obj.PropInfo;
import org.garden.cfg.core.exception.DataException;
import org.garden.cfg.core.repository.CfgDao;
import org.garden.cfg.core.repository.entity.CfgApp;
import org.garden.cfg.core.repository.entity.CfgAppExample;
import org.garden.cfg.core.repository.entity.CfgDoc;
import org.garden.cfg.core.repository.entity.CfgDocExample;
import org.garden.cfg.core.repository.entity.CfgEnv;
import org.garden.cfg.core.repository.entity.CfgEnvExample;
import org.garden.cfg.core.repository.entity.CfgItem;
import org.garden.cfg.core.repository.entity.CfgItemExample;
import org.garden.cfg.core.repository.entity.CfgUser;
import org.garden.cfg.core.repository.entity.CfgUserExample;
import org.garden.cfg.core.repository.mapper.CfgAppMapper;
import org.garden.cfg.core.repository.mapper.CfgDocMapper;
import org.garden.cfg.core.repository.mapper.CfgEnvMapper;
import org.garden.cfg.core.repository.mapper.CfgItemMapper;
import org.garden.cfg.core.repository.mapper.CfgUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ManagerService {

	private static final Logger log = LoggerFactory.getLogger(ManagerService.class);

	@Autowired
	private CfgUserMapper cfgUserMapper;

	@Autowired
	private CfgAppMapper cfgAppMapper;

	@Autowired
	private CfgEnvMapper cfgEnvMapper;

	@Autowired
	private CfgDocMapper cfgDocMapper;
	
	@Autowired
	private CfgItemMapper cfgItemMapper;

	@Autowired
	private CfgDao cfgDao;

	public boolean login(String userCode, String password) {
		CfgUserExample example = new CfgUserExample();
		example.createCriteria().andUserCodeEqualTo(userCode).andPasswordEqualTo(password).andStatusEqualTo(1);
		List<CfgUser> users = cfgUserMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(users)) {
			return false;
		}
		return true;
	}

	public List<CfgApp> getApps(String userCode) {
		List<CfgApp> apps = cfgDao.getApps(userCode);
		return apps;
	}

	public CfgApp getApp(String appCode) {
		CfgAppExample example = new CfgAppExample();
		example.createCriteria().andAppCodeEqualTo(appCode).andStatusEqualTo(1);
		List<CfgApp> apps = cfgAppMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(apps)) {
			String msg = MessageFormat.format("无应用（{0}）相关信息", appCode);
			log.warn(msg);
			throw new DataException(msg);
		}
		return apps.get(0);
	}

	public List<CfgEnv> findEnvs() {
		CfgEnvExample example = new CfgEnvExample();
		example.createCriteria().andStatusEqualTo(1);
		List<CfgEnv> envs = cfgEnvMapper.selectByExample(example);
		return envs;
	}

	public List<CfgDoc> findDocs(String appCode, String envCode, String clusterCode) {
		CfgDocExample example = new CfgDocExample();
		example.createCriteria().andStatusEqualTo(1).andAppCodeEqualTo(appCode).andEnvCodeEqualTo(envCode)
				.andClusterCodeEqualTo(clusterCode);
		List<CfgDoc> docs = cfgDocMapper.selectByExample(example);
		return docs;
	}

	/**
	 * 获取文档所有配置项
	 * 
	 * @param docId
	 * @return
	 */
	public List<CfgItem> getDocProps(Integer docId) {
		
		CfgItemExample example = new CfgItemExample();
		example.createCriteria().andDocIdEqualTo(docId);
		example.setOrderByClause("position, item_id  ASC");
		return cfgItemMapper.selectByExample(example);
	}

	/**
	 * 文档末尾添加配置项
	 * @param userCode 
	 * 
	 * @param docId
	 * @param props
	 * @return
	 */
	public boolean addDocProps(String userCode, Integer docId, List<PropInfo> props) {
		Date now = new Date();
		
		Integer lastPosition = cfgDao.getLastPosition(docId);
		if (lastPosition == null) {
			lastPosition = -1;
		}
		List<CfgItem> items = new ArrayList<>();
		for (PropInfo prop : props) {
			CfgItem item = new CfgItem();
			item.setDocId(docId);
			item.setKey(prop.getKey());
			item.setValue(prop.getValue());
			item.setComment(prop.getComment());
			item.setText(prop.getText());
			item.setPosition(++lastPosition);
			item.setCreateUserCode(userCode);
			item.setCreateTime(now);
			item.setUpdateUserCode(userCode);
			item.setUpdateTime(now);
			
			items.add(item);
		}
		cfgDao.addProps(items);
		return true;
	}

	public CfgDoc getDocById(Integer docId) {
		CfgDocExample example = new CfgDocExample();
		example.createCriteria().andStatusEqualTo(1).andDocIdEqualTo(docId);
		List<CfgDoc> docs = cfgDocMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(docs)) {
			String msg = MessageFormat.format("无文档（{0}）相关信息", docId);
			log.warn(msg);
			throw new DataException(msg);
		}
		return docs.get(0);
	}

	public boolean deleteDocProps(Integer docId, List<Integer> propIds) {

		CfgItemExample example = new CfgItemExample();
		example.createCriteria().andDocIdEqualTo(docId).andItemIdIn(propIds);
		cfgItemMapper.deleteByExample(example);
		return true;
	}

	@Transactional
	public boolean updateDocProps(String userCode, Integer docId, List<PropInfo> props) {
		for(PropInfo p: props) {
			CfgItemExample example = new CfgItemExample();
			example.createCriteria().andStatusEqualTo(1).andDocIdEqualTo(docId).andItemIdEqualTo(p.getItemId());
			CfgItem item = new CfgItem();
			item.setKey(p.getKey());
			item.setValue(p.getValue());
			item.setComment(p.getComment());
			item.setUpdateUserCode(userCode);
			item.setUpdateTime(new Date());
			int num = cfgItemMapper.updateByExampleSelective(item, example);
			if (num != 1) {
				throw new DataException(MessageFormat.format("配置项{0}更新异常,更新记录数{1}", p.getItemId(), num));
			}
		}
		return true;
	}
}

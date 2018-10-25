package org.garden.cfg.core.util;

public class CfgUtils {
	
	private static ExpiredMap<String, String> userInfoMap = new ExpiredMap<>();
	
	public static ExpiredMap<String, String> getUserInfos(){
		return userInfoMap;
	}
	
	public static String putUserInfo(String key, String value){
		return userInfoMap.put(key, value);
	}
	
	public static String getUserInfo(String key){
		return userInfoMap.get(key);
	}
}

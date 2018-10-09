package org.garden.cfg.core.util;

public class CfgUtils {
	
	private static ExpiredMap<String, String> userInfoMap = new ExpiredMap<>();
	
	public static ExpiredMap<String, String> getUserInfos(){
		return userInfoMap;
	}
}

package org.garden.cfg.controller.obj;

public class AppInfo {
	private Integer appId;
	private String appCode;
	private String appName;
	private String comment;

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "AppInfo [appId=" + appId + ", appCode=" + appCode + ", appName=" + appName + ", comment=" + comment
				+ "]";
	}

}

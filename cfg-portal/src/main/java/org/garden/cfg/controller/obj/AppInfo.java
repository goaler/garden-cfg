package org.garden.cfg.controller.obj;

import org.garden.cfg.core.repository.entity.CfgApp;

public class AppInfo {
	private Integer id;
	private String name;
	private String code;
	private String comment;
	
	public AppInfo() {
		
	}
	
	public AppInfo(CfgApp app) {
		this.id = app.getAppId();
		this.name = app.getAppName();
		this.code = app.getAppCode();
		this.comment = app.getComment();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "AppInfo [id=" + id + ", name=" + name + ", code=" + code + ", comment=" + comment + "]";
	}

}

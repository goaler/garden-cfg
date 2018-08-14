package org.garden.cfg.controller.obj;

import org.garden.cfg.core.repository.entity.CfgEnv;

public class EnvInfo {
	private Integer envId;

	private String envCode;

	private String envName;

	private String comment;

	public EnvInfo() {

	}

	public EnvInfo(CfgEnv env) {
		this.envId = env.getEnvId();
		this.envCode = env.getEnvCode();
		this.envName = env.getEnvName();
		this.comment = env.getComment();
	}

	public Integer getEnvId() {
		return envId;
	}

	public void setEnvId(Integer envId) {
		this.envId = envId;
	}

	public String getEnvCode() {
		return envCode;
	}

	public void setEnvCode(String envCode) {
		this.envCode = envCode;
	}

	public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "EnvInfo [envId=" + envId + ", envCode=" + envCode + ", envName=" + envName + ", comment=" + comment
				+ "]";
	}

}

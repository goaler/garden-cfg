package org.garden.cfg.controller.obj;

public class LoginReq {
	private String userCode;
	private String password;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginReq [userCode=" + userCode + ", password=" + password + "]";
	}

}

package org.garden.cfg.core.exception;

public class SysException extends RuntimeException {

	private static final long serialVersionUID = -7119322397246646362L;

	private int errorCode = 1500;

	private String msg;

	private Throwable throwable;

	public SysException(String msg) {
		this.msg = msg;
	}

	public SysException(int errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	
	public SysException(String msg, Throwable throwable) {
		super(throwable);
		this.msg = msg;
		this.throwable = throwable;
	}

	public SysException(int errorCode, String msg, Throwable throwable) {
		super(throwable);
		this.errorCode = errorCode;
		this.msg = msg;
		this.throwable = throwable;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	@Override
	public String toString() {
		return "BaseException [errorCode=" + errorCode + ", msg=" + msg + ", throwable=" + throwable + "]";
	}

}

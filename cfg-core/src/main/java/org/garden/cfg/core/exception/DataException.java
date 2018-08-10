package org.garden.cfg.core.exception;

public class DataException extends SysException {
	private static final long serialVersionUID = 6746359274280603063L;
	
	
	public  DataException() {
		super("服务数据故障！请检查请求数据");
	}

	public DataException(String msg) {
		super(msg);
	}
	
	public DataException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}

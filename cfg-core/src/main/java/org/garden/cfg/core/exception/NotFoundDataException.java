package org.garden.cfg.core.exception;

public class NotFoundDataException extends DataException {
	private static final long serialVersionUID = -2324355275403187218L;

	public NotFoundDataException() {
		super("无请求数据记录。");
	}
}

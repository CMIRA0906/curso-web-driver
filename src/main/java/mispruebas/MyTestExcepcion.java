package mispruebas;

import okhttp3.internal.http2.ErrorCode;

public class MyTestExcepcion extends Exception{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final ErrorCode code;
	
	public MyTestExcepcion(String message, Throwable cause, ErrorCode code) {
		super(message, cause);
		this.code = code;
	}
	
	public MyTestExcepcion(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}
	

	public MyTestExcepcion(Throwable cause, ErrorCode code) {
		super(cause);
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}

}

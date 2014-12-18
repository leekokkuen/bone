package com.bone.service.common;

import java.text.MessageFormat;


public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -6401601299173462965L;

	public static final String FAILURE = "FAILURE";
	public static final String WARNING = "WARNING";

	private String code = "";

	public static ServiceException create(String message,Object ... arguments){
		return new ServiceException(MessageFormat.format(message, arguments));
	}
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(message);
        setCode(code);
    }

    public ServiceException(String code, Throwable cause) {
        super(cause);
        setCode(code);
    }

    public ServiceException(String message, String code, Throwable cause) {
        super(message, cause);
        setCode(code);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }
}

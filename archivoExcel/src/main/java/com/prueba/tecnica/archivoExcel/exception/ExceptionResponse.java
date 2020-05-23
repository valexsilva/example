package com.prueba.tecnica.archivoExcel.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String userMessage;
	private String internalMessage;
	private String moreInfo;
	private Integer code;
	
	public ExceptionResponse(Date timestamp, String userMessage, String internalMessage, String moreInfo,
			Integer code) {
		super();
		this.timestamp = timestamp;
		this.userMessage = userMessage;
		this.internalMessage = internalMessage;
		this.moreInfo = moreInfo;
		this.code = code;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String more_info) {
		this.moreInfo = more_info;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}

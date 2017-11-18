package org.wingame.action;

import com.opensymphony.xwork2.ActionSupport;

public class MessageActionBase extends ActionSupport {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

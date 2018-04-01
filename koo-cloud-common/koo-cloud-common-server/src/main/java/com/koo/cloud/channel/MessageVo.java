package com.koo.cloud.channel;

import java.io.Serializable;

public class MessageVo implements Serializable {
	private static final long serialVersionUID = 435098194581138140L;
	private String title;
	private String body;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MessageVo [title=" + title + ", body=" + body + "]";
	}
	
}

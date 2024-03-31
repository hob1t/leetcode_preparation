package com.bigpanda.exe;

import java.util.UUID;

public class Message {
	private UUID id;
	private String host;
	private String message;
	private String status;
	
	
	public Message(UUID id, String host, String message, String status) {
		super();
		this.id = id;
		this.host = host;
		this.message = message;
		this.status = status;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}

package com.navan.exe;

import java.io.Serializable;

public class MyMessage implements Message, Serializable {
    private String topic;
    private String payload;
	private static final long serialVersionUID = 1L;
	
	public MyMessage(String topic, String payload) {
		this.topic = topic;
		this.payload = payload;
	}


	@Override
	public String getTopic() {
		return this.topic;
	}

	
	@Override
	public String getPayload(String payload) {
		return this.payload;
	}

}

package com.navan.exe;

public interface ConsumerCallback {
	String getConsumerName();
	void send(Message message);
}

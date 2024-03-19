package com.navan.exe;

public class MyConsumerCallback implements ConsumerCallback {
	private String consumerName;
	
	public MyConsumerCallback(String consumerName) {
		this.consumerName = consumerName;
	}

	@Override
	public void send(Message message) {
		System.out.println("Name:=" + getConsumerName() + ", topic:=" + message.getTopic() + ", payload:= " + message.getPayload(consumerName));
	}

	@Override
	public String getConsumerName() {
		return this.consumerName;
	}
}

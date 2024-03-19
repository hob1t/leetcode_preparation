package com.navan.exe;

public interface IMessageBroker {
	void register(String topic, ConsumerCallback consumer);
    void send(Message message);
    void shutdown();

}

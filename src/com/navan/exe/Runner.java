package com.navan.exe;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class Runner {
	
	public static MyMessage createMessage(String topic, String payload) {
		return new MyMessage(topic, payload);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Consumer 1 registers to A
		// Consumer 2 registers to B and C
		// Consumer 3 registers to A, B C
		// not multi threading
		MyMessageBroker broker = new MyMessageBroker();
		// register customer 1
		MyConsumerCallback consumer_1 = new MyConsumerCallback("consumer_1");
		broker.register("topicA", consumer_1);
		
		MyConsumerCallback consumer_2 = new MyConsumerCallback("consumer_2");
		broker.register("topicB", consumer_2);
		broker.register("topicC", consumer_2);
		
		MyConsumerCallback consumer_3 = new MyConsumerCallback("consumer_3");
		broker.register("topicA", consumer_3);
		broker.register("topicB", consumer_3);
		broker.register("topicB", consumer_3);
		
		System.out.println("All consumers are registered" + LocalDateTime.now());
		
		IntStream.range(0,500000).forEach(el -> {
			broker.send(Runner.createMessage("topicA", "Hello from " + System.nanoTime()));
			broker.send(Runner.createMessage("topicB", "Hello from " + System.nanoTime()));
			broker.send(Runner.createMessage("topicC", "Hello from " + System.nanoTime()));
		});
		
		broker.shutdown();
		System.out.println("All consumers are finished" + LocalDateTime.now());
	}
}

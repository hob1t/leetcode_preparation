package com.navan.exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMessageBroker implements IMessageBroker {
	private Map<String, List<ConsumerCallback>> messageBus = new ConcurrentHashMap<>();
	private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	// java.util.concurrent: CopyOnWriteArrayList
	
	@Override
	public void register(String topic, ConsumerCallback consumer) {
		if(!messageBus.containsKey(topic)) {
			List<ConsumerCallback> list = new ArrayList<>();
			list.add(consumer);
			messageBus.put(topic, list);
		} else {
			List<ConsumerCallback> tmp = messageBus.get(topic);
			tmp.add(consumer);
			messageBus.put(topic, tmp);
		}
		
	}

	@Override
	public void send(Message message) {
		CopyOnWriteArrayList<ConsumerCallback> callbacks = new CopyOnWriteArrayList<ConsumerCallback>(messageBus.get(message.getTopic()));

		for(ConsumerCallback cb : callbacks) {
			executor.execute(() -> {
				cb.send(message);
			});
		}
	}

	@Override
	public void shutdown() {
		executor.shutdown();
	}
}

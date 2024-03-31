package com.bigpanda.exe;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyAlertFilter implements AlertFilter {
	private Map<String, String> dataStorage = new HashMap<>();

	@Override
	public boolean filter(String alertJsonString) {
		//ObjectMapper obj = new ObjectMapper();
		//UUID id, String host, String message, String status
		Message msg = new Message(UUID.randomUUID(), "host_1_123", "hdb fsfsf", "critical");
		// TODO Auto-generated method stub
		// calculation of 1/2 hour
		// a + 12:32:23
		// a + 12:33:34
		// 
		String key = msg.getHost() + msg.getMessage();
		
		if(dataStorage.containsKey(key)) {
			// result of time 
			long current = LocalDate.now().getLong(ChronoField.SECOND_OF_MINUTE);
			if(current >= 30) {
				return true;
			}
		} else {
			dataStorage.put(key, alertJsonString);
		}
		
		return false;
	}

}

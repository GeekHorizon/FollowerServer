package com.kwon.server.message;

import com.kwon.client.UserManagement;

/**
 * 이벤트 메시지
 * @author kwon hyeok cheol
 *
 */
public class FactoryEvent {
	public static Event getEvent(String message, UserManagement userManagement) {
		
		Event event = new Event();
		
		String[] messageSplit = message.trim().split("\\|");
		
		event.setSequence(Integer.parseInt(messageSplit[0]));
		event.setType(messageSplit[1]);
		
		if (messageSplit.length >= 3) {
			event.setFromUser(userManagement.getUser(Integer.parseInt(messageSplit[2])));
		}
		
		if (messageSplit.length >= 4) {
			event.setToUser(userManagement.getUser(Integer.parseInt(messageSplit[3])));
		}
		
		event.setEventMessage(message);
		
		return event;
	}
}

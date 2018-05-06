package com.kwon.service;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.kwon.client.User;
import com.kwon.client.UserManagement;
import com.kwon.logger.Logger;
import com.kwon.server.message.Event;
import com.kwon.server.message.FactoryEvent;
import com.kwon.server.message.commend.FollowerMessageInvoker;

/**
 * 팔로우 서비스 
 * @author kown hyeok-cheol
 *
 */
public class ServerService {
	private UserManagement userManagement = new UserManagement();
	private Map<Integer, Event> messageLog = new HashMap<Integer, Event>();	
	private FollowerMessageInvoker messageInvoker = new FollowerMessageInvoker();
	
	private boolean firstSequenceMessageReceive = false;
	private int sequence = 1;
	
	public void addUser(User user) {
		Logger.info("client loginID : " + user.getUserId() + " socket : " + user.getConnectionSocket());
		userManagement.addUser(user);
	}

	public void notify(Event event, User... sendUsers) {
		for (User user : sendUsers) {
			Socket userSocket = user.getConnectionSocket();

			if (null == userSocket) {
				continue;
			}

			try {
				new PrintWriter(userSocket.getOutputStream(), true).println(event.getEventMessage());
				Logger.debug("send {toUserId : " + user.getUserId() + "}  message : " + event.getEventMessage());

			} catch (Exception e) {
				Logger.error("send  {toUserId : " + user.getUserId() + "}  message : " + event.getEventMessage());
			}
		}
	}
	
	public void eventFetch(String eventMessage) {
		Event message = FactoryEvent.getEvent(eventMessage, userManagement);
		if (false == firstSequenceMessageReceive) {
			sequence = message.getSequence();
			firstSequenceMessageReceive = true;
		}
		
		messageLog.put(message.getSequence(), message);

		while (true == messageLog.containsKey(sequence)) {
			messageInvoker.action(messageLog.remove(sequence++), this);
		}
	}

	public UserManagement getUserManagement() {
		return userManagement;
	}
}

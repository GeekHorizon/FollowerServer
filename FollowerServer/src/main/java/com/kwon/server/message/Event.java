package com.kwon.server.message;

import com.kwon.client.User;

public class Event {
	private int sequence;
	private String type;
	private User fromUser;
	private User toUser;
	private String eventMessage;
	
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	public String getEventMessage() {
		return eventMessage;
	}
	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}


}

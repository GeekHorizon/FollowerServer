package com.kwon.client;

import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * 클라이언트 대상인 유저 
 * 팔로우 정보 관리 
 * @author kown hyeok-cheol
 *
 */
public class User {
	private int userId;
	private Socket connectionSocket;
	private Set<Integer> followerUserIds = new HashSet<Integer>();
	
	public User(int userId) {
		this.userId = userId;
	}
	
	public User(int userId, Socket socket) {
		this.userId = userId;
		this.connectionSocket = socket;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void follow(int followerId) {
		followerUserIds.add(followerId);
	}
	
	public void unfollow(Integer unFollowId) {
		followerUserIds.remove(unFollowId);
	}
	
	public Integer[] getFollowerUserIds() {
		Integer[] returnValue = followerUserIds.toArray(new Integer[followerUserIds.size()]);
		return returnValue;
	}

	public Socket getConnectionSocket() {
		return connectionSocket;
	}

	public void setConnectionSocket(Socket connectionSocket) {
		this.connectionSocket = connectionSocket;
	}
	
	@Override
	public int hashCode() {
		return userId;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof User) {
			User b = (User)o;
			return this.userId == b.userId;
		}
		
		return false;
	}
	
}

package com.kwon.client;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 유저 관리
 * @author kown hyeok-cheol
 *
 */
public class UserManagement {
	private Set<User> userSet = new HashSet<User>();
	private Map<Integer, User> users = new HashMap<Integer, User>();
	
	public void addUser(int userId) {
		User user = new User(userId);
		users.put(userId, user);
		userSet.add(user);
	}

	public void addUser(User user) {
		users.put(user.getUserId(), user);
		userSet.add(user);
	}
	
	public User getUser(int userId) {
		if (false == users.containsKey(userId)) {
			addUser(userId);
		}
		
		return users.get(userId);
	}
	
	public User[] allUsers() {
		return userSet.toArray(new User[userSet.size()]);
	}
}

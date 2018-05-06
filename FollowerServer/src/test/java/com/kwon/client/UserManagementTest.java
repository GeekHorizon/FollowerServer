package com.kwon.client;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 유저 관리 테스트 
 * @author kown hyeok-cheol
 *
 */
public class UserManagementTest {

	/**
	 * 보관된 유저를 정상적으로 가져오는지 테스트  
	 */
	@Test
	public void test() {
		
		User User1 = new User(1234);
		UserManagement userMm = new UserManagement();
		userMm.addUser(User1);
		
		assertEquals(User1.getUserId(), userMm.getUser(User1.getUserId()).getUserId());
		
		User user2 = new User(1235);
		userMm.addUser(user2);
		
		User User3 = new User(1236);
		userMm.addUser(User3);
		
		Set<User> testSet = new HashSet<User>();
		testSet.add(User1);
		testSet.add(user2);
		testSet.add(User3);
		
		for (User user : userMm.allUsers()) {
			testSet.remove(user);
		}
		
		assertTrue(testSet.size() == 0);
	}

}

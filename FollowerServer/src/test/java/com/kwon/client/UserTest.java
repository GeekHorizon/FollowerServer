package com.kwon.client;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 유저 클래스의 테스트클래
 * @author kown hyeok-cheol
 *
 */
public class UserTest {

	/**
	 * 유저 생성 아이디 확인 
	 */
	@Test
	public void testCreateUser() {
		int testFromUserId = 1001;
		User user = new User(testFromUserId);
		
		assertEquals(testFromUserId, user.getUserId());
	}

	/**
	 * 유저 팔로우 확인 
	 */
	@Test
	public void testFollow() {
		int testFromUserId = 1001;
		User user = new User(testFromUserId);
		
		int[] followUserIds = {1111, 1234, 1513};
		Set<Integer> followUserSet = new HashSet<Integer>();
		
		for (int floowUserId : followUserIds) {
			user.follow(floowUserId);
			followUserSet.add(floowUserId);
		}
		
		for (int userId : user.getFollowerUserIds()) {
			followUserSet.remove(userId);
		}
		
		assertTrue(followUserSet.size() == 0);
	}

	/**
	 * 유저 언팔로우 테스트 
	 */
	@Test
	public void testUnfollow() {
		int testFromUserId = 1001;
		User user = new User(testFromUserId);
		
		int[] followUserIds = {1111, 1234, 1513};
		
		for (int floowUserId : followUserIds) {
			user.follow(floowUserId);
		}
		
		user.unfollow(1234);
		user.unfollow(1513);
		
		assertTrue(1111 == user.getFollowerUserIds()[0]);;	
		
		
	}

}

package com.kwon.server.message.commend;

import com.kwon.client.User;
import com.kwon.client.UserManagement;
import com.kwon.server.message.Event;
import com.kwon.service.ServerService;

/**
 * **Status Update**: All current followers of the `From User ID` should be notified
 * 
 * @author kown hyeok-cheol
 *
 */
public class StatusUpdateCommend implements FollowerMessageCommend {
	
	@Override
	public void execute(Event event, ServerService serverService) {
		UserManagement userManagement = serverService.getUserManagement();
		Integer[] userIds = event.getFromUser().getFollowerUserIds();
		User[] users = new User[userIds.length];
		
		int index = 0;
		for (Integer userId : userIds) {
			users[index++] = userManagement.getUser(userId);
		}
		
		serverService.notify(event, users);
	}
}

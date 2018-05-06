package com.kwon.server.message.commend;

import com.kwon.client.UserManagement;
import com.kwon.server.message.Event;
import com.kwon.service.ServerService;

/**
 * **Broadcast**: All connected *user clients* should be notified
 * @author kown hyeok-cheol
 *
 */
public class BroadcastCommend implements FollowerMessageCommend {
	
	@Override
	public void execute(Event event, ServerService serverService) {
		UserManagement userManagement = serverService.getUserManagement();
		serverService.notify(event, userManagement.allUsers());
	}
}

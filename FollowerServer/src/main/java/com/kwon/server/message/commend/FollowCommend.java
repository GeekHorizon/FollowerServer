package com.kwon.server.message.commend;

import com.kwon.server.message.Event;
import com.kwon.service.ServerService;

/**
 * **Follow**: Only the `To User Id` should be notified
 * 
 * @author kown hyeok-cheol
 *
 */
public class FollowCommend implements FollowerMessageCommend {

	@Override
	public void execute(Event event, ServerService serverService) {
		event.getToUser().follow(event.getFromUser().getUserId());
		serverService.notify(event, event.getToUser());
	}
	
};
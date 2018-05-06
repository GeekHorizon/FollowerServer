package com.kwon.server.message.commend;

import com.kwon.server.message.Event;
import com.kwon.service.ServerService;

/**
 * **Private Message**: Only the `To User Id` should be notified
 * 
 * @author kown hyeok-cheol
 *
 */
public class PrivateMessageCommend implements FollowerMessageCommend {

	@Override
	public void execute(Event event, ServerService serverService) {
		serverService.notify(event, event.getToUser());
	}
}

package com.kwon.server.message.commend;

import com.kwon.server.message.Event;
import com.kwon.service.ServerService;

/** 
 * **Unfollow**: No clients should be notified
 *
 */
public class UnFollowCommend implements FollowerMessageCommend  {

	@Override
	public void execute(Event event, ServerService serverService) {
		event.getToUser().unfollow(event.getFromUser().getUserId());
	}
}

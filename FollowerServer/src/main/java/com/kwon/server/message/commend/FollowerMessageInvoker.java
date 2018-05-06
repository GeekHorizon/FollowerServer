package com.kwon.server.message.commend;

import java.util.HashMap;
import java.util.Map;

import com.kwon.server.message.Event;
import com.kwon.server.message.FactoryEvent;
import com.kwon.service.ServerService;

/**
 * 메세지 분석기
 * @author kown hyeok-cheol
 *
 */
public class FollowerMessageInvoker {
	public Map<String, FollowerMessageCommend> commends = new HashMap<String, FollowerMessageCommend>();
	
	public FollowerMessageInvoker() {
		commends.put("F", new FollowCommend());
		commends.put("U", new UnFollowCommend());
		commends.put("B", new BroadcastCommend());
		commends.put("P", new PrivateMessageCommend());
		commends.put("S", new StatusUpdateCommend());
	}
	
	public void action(Event event, ServerService serverService) {
		FollowerMessageCommend commend = commends.get(event.getType());

		if (commend != null) {
			commend.execute(event, serverService);
		}
	}
}

package com.kwon.server.message.commend;

import com.kwon.server.message.Event;
import com.kwon.service.ServerService;

/**
 * 
 * | Payload    | Sequence #| Type         | From User Id | To User Id |
 * |------------|-----------|--------------|--------------|------------|
 * |666|F|60|50 | 666       | Follow       | 60           | 50         |
 * |1|U|12|9    | 1         | Unfollow     | 12           | 9          |
 * |542532|B    | 542532    | Broadcast    | -            | -          |
 * |43|P|32|56  | 43        | Private Msg  | 32           | 56         |
 * |634|S|32    | 634       | Status Update| 32           | -          |
 * 
 * **Follow**: Only the `To User Id` should be notified
 * **Unfollow**: No clients should be notified
 * **Broadcast**: All connected *user clients* should be notified
 * **Private Message**: Only the `To User Id` should be notified
 * **Status Update**: All current followers of the `From User ID` should be notified
 * @author kwon hyeok cheol
 *
 */
public interface FollowerMessageCommend {
	public void execute(Event event, ServerService serverService);
}

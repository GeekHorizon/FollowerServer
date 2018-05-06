package com.kwon.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.kwon.logger.Logger;
import com.kwon.server.ClientsServer;
import com.kwon.server.EventServer;
import com.kwon.server.Server;

/**
 * 팔로우 서버 서비스
 * @author kown hyeok-cheol
 *
 */
public class FollowerService {
	private Server clientsServer;
	private Server eventServer;
	private ServerService serverService;
	
	public FollowerService(int clientsPort, int eventPort) {
		serverService = new ServerService();
		clientsServer = new ClientsServer(clientsPort, serverService);
		eventServer = new EventServer(eventPort, serverService);
	}
	
	public void start() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(clientsServer);
		executor.execute(eventServer);
		while (!executor.isTerminated()) {}
	}
	
	public static void main(String[] args) {
		Logger.setDebug(true);
		new FollowerService(9099, 9090).start();
	}
}

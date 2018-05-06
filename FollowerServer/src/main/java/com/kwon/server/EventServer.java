package com.kwon.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.kwon.io.TCPServerException;
import com.kwon.service.ServerService;

/**
 * 이벤트 처리 서버 
 * @author kown hyeok-cheol
 *
 */
public class EventServer extends Server {
	
	public EventServer(int port, ServerService serverService) {
		super(port, serverService);
	}
	
	@Override
	public void run() {
		Socket client = this.accept();
		while (true) {
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String line = bufferedReader.readLine();
				while (line != null) {
					serverService.eventFetch(line);
					line = bufferedReader.readLine();
				}
				
			} catch (IOException e) {
				new TCPServerException(e);
			}
		}
	}
}

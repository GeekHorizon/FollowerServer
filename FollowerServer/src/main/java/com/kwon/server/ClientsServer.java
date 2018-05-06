package com.kwon.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.kwon.client.User;
import com.kwon.io.TCPServerException;
import com.kwon.service.ServerService;

/**
 * 클라이언트 접속서버 
 * @author kown hyeok-cheol
 *
 */
public class ClientsServer extends Server {
	
	public ClientsServer(int port, ServerService serverService) {
		super(port, serverService);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket client = this.accept();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String line = bufferedReader.readLine();

				if (null != line && !"".equals(line.trim())) {
					
					User user = new User(Integer.parseInt(line));
					user.setConnectionSocket(client);
					
					
					serverService.addUser(user);
				}
			} catch (IOException e) {
				new TCPServerException(e);
			}
			
		}
	}
}

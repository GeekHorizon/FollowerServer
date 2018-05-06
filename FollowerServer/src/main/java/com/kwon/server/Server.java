package com.kwon.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.kwon.io.Connection;
import com.kwon.io.TCPServerException;
import com.kwon.logger.Logger;
import com.kwon.service.ServerService;

/**
 * 기본 서버 
 * @author kwon hyeok cheol
 *
 */
public abstract class Server implements Runnable {
	
	/**
	 * 기본 포트 9999
	 */
	protected int port = 9999;
	protected Connection connection; 
	protected ServerService serverService;
	
	public Server(int port, ServerService serverService) {
		this.port = port;
		this.serverService = serverService;
		open();
	}
	
	protected void open() {
		connection = new Connection(port);
		Logger.info("open port : " + port);
	}
	
	public Socket accept() throws TCPServerException {
		ServerSocket serverSocket = connection.getServerSocket();
		try {
			return serverSocket.accept();
		} catch (IOException e) {
			throw new TCPServerException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public abstract void run();
	
}

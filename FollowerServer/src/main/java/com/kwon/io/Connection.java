package com.kwon.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 연결관리
 * @author kown hyeok-cheol
 *
 */
public class Connection {

	private ServerSocket socket;

	public Connection(int port) throws TCPServerException {
		try {
			socket = new ServerSocket(port);
			socket.setReuseAddress(true);
		} catch (IOException e) {
			throw new TCPServerException(e);
		}
	}

	public Socket open() throws TCPServerException {
		try {
			return socket.accept();
		} catch (IOException e) {
			throw new TCPServerException(e);
		}
	}

	public ServerSocket getServerSocket() {
		return this.socket;
	}
	
	
}

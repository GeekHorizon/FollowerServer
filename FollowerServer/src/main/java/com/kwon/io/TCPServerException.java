package com.kwon.io;

/**
 * 복구불가 오류 언체크 익셉션으로 변
 * @author kwon hyeok cheol
 *
 */
@SuppressWarnings("serial")
public class TCPServerException extends RuntimeException {
	
	public TCPServerException(Exception e) {
		super(e);
	}
	
	public TCPServerException() {
		super();
	}
}
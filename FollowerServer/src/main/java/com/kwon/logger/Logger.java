package com.kwon.logger;

/**
 * Log 클래
 * @author kwon hyeok cheol
 *
 */
public class Logger {
	
	private boolean debug = false;
	
	private static class Instance {
		private static Logger instance = new Logger();
	}
	
	private Logger() {
	}
	
	public static Logger getInstance() {
		return Instance.instance;
	}

	public static void info(String message) {
		Instance.instance.print("info", message);
	}
	
	public static void debug(String message) {
		if (Instance.instance.debug) {
			Instance.instance.print("debug", message);
		}
	}
	
	public static void error(String message) {
		Instance.instance.print("error", message);
	}
	
	public static void setDebug(boolean isDebug) {
		Instance.instance.debug = isDebug;
	}
	
	public boolean isDebug() {
		return debug;
	}
	
	private void print(String... message) {
		System.out.format("[%s] %s\n", message[0], message[1]);
	}

}

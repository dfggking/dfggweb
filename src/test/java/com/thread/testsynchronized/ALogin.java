package com.thread.testsynchronized;

public class ALogin extends Thread {

	@Override
	public void run() {
		LoginServlet.post("a", "aa");
	}
}

package com.thread.testsynchronized;

public class BLogin extends Thread {

	@Override
	public void run() {
		LoginServlet.post("b", "bb");
	}
}

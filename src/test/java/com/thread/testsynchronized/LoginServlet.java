package com.thread.testsynchronized;

import java.util.Objects;

public class LoginServlet {
	private static String usernameRef;
	private static String passwordRef;
	
	synchronized public static void post(String username, String password) {
		try {
			usernameRef = username;
			if(Objects.equals(username, "s")){
				Thread.sleep(5000);
			}
			passwordRef = password;
			System.out.println("username=" + usernameRef + " password=" 
					+ password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

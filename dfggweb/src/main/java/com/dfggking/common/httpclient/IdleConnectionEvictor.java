package com.dfggking.common.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * httpclient连接池清理无效连接的线程
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月28日 下午4:16:31 
 * @since
 */
public class IdleConnectionEvictor extends Thread {
	private final HttpClientConnectionManager connMgr;
	private volatile boolean shutdown; /**多线程共享状态*/
	
	public IdleConnectionEvictor(HttpClientConnectionManager connMgr){
		this.connMgr = connMgr;
		this.start(); /*启动当前线程*/
	}
	
	public void run(){
		try {
			while (!shutdown) {
				synchronized (this) {
					wait(5000);
					/**关闭无效的连接*/
					connMgr.closeExpiredConnections();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shutdown(){
		shutdown = true;
		synchronized (this) {
			notifyAll();
		}
	}
}

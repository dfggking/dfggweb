package com.thread;
/**
 * Thread与Runnable我的理解：
 * Thread继承了Runnable，Java是单继承，如果一个类已经继承了其他类，再实现多线程就可以实现Runnable接口
 * 
 * <p></p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年3月28日 下午10:02:31 
 * @since
 */
public class TestRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("运行中！");
	}

	
	public static void main(String[] args) {
		
		TestRunnable myRunnable = new TestRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
		System.out.println("运行结束！");
	}
	
}

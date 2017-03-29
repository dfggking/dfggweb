package com.thread;

public class TestThread extends Thread {

	private int count = 5;
	
	public TestThread(String name) {
		super();
		this.setName(name);
	}
	@Override
	public void run() {
		super.run();
		while (count > 0) {
			count--;
			System.out.println("由 " + Thread.currentThread().getName()
					+ " 计算， count=" + count);
		}
//		System.out.println("TestThread run();");
	}
//	@Override
//	public void run() {
//		try {
//			for (int i = 0; i < 10; i++) {
//				int time = (int) (Math.random() * 1000);
//				Thread.sleep(time);
//				System.out.println("run=" + Thread.currentThread().getName());
//			}
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
	public static void main(String[] args) {
		
		TestThread a = new TestThread("A");
		TestThread b = new TestThread("B");
		TestThread c = new TestThread("C");
		a.start();
		b.start();
		c.start();
		
		
//		TestThread myThread = new TestThread();
//		myThread.setName("myThread");
//		myThread.start();
//		try {
//			for (int i = 0; i < 10; i++) {
//				int time = (int) (Math.random() * 1000);
//				Thread.sleep(time);
//				System.out.println("main=" + Thread.currentThread().getName());
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("运行结束！ ");
		
//		System.out.println(Thread.currentThread().getName()); // main 跟main方法 没有任何关系
	}

}

package main;

import systemMonitor.SystemMonitor;

public class Main {
	static SystemMonitor monitor;

	public static void main(String[] args) {
		System.out.println("Start");
		monitor = new SystemMonitor();
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

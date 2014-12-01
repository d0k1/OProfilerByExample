package com.focusit.profiling;

/**
 * Created by Denis V. Kirpichenkov on 02.12.14.
 */
public class Target {
	public static void main(String[] args) throws InterruptedException {
		int count = 2;
		Thread threads[] = new Thread[count];

		for(int i=0;i<count;i++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i<10010;i++) {
						new ClassThree().doMostValuableJob(new ClassTwo());
					}
				}
			});
			threads[i] = t;
			t.start();
		}

		for(int i=0;i<count;i++){
			threads[i].join();
		}
	}
}

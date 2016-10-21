package com.threadLocal.test1;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by applec on 16/4/11.
 * used to test ThreadLocal variable
 */
@Deprecated // not working correctly
public class DemoTest implements Runnable {

	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// Thread local variable containing each thread's ID
	private static final ThreadLocal<Integer> threadId =
			new ThreadLocal<Integer>() {
				@Override
				protected Integer initialValue() {
					return nextId.getAndIncrement();
				}
			};

	// Returns the current thread's unique ID, assigning it if necessary
	public int getThreadId() {
		return threadId.get();
	}

	// Returns the current thread's starting timestamp
	private static final ThreadLocal<Date> startDate =
			new ThreadLocal<Date>() {
				protected Date initialValue() {
					return new Date();
				}
			};

	@Override
	public void run() {
		System.out.printf("Starting Thread: %s : %sn",
				getThreadId(), startDate.get());
		System.out.println();
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %sn",
				getThreadId(), startDate.get());
		System.out.println();
	}

	public static void main(String[] args) {
		DemoTest demoTest1 = new DemoTest();
		demoTest1.run();
		DemoTest demoTest2 = new DemoTest();
		demoTest2.run();
		DemoTest demoTest3 = new DemoTest();
		demoTest3.run();
	}
}
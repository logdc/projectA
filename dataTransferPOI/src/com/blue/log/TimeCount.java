package com.blue.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * count time init
 * Created by applec on 15/11/25.
 */
public class TimeCount {

	private static long START_TIME = 0;

	private static List<Long> PERIOD_TIME_LIST = new ArrayList<Long>();

	private TimeCount(){}

	public static void initTimeCountStub(){
		START_TIME = System.currentTimeMillis();
		System.out.println("Program started: " + new Date());
	}

	/**
	 * stub put where count time needed
	 * @param periods
	 */
	public static long putTimeCountStub(int periods){
		PERIOD_TIME_LIST.add(System.currentTimeMillis());
		long neededTimeStub;
		if(periods <= 0 || periods > PERIOD_TIME_LIST.size()){
			neededTimeStub = START_TIME;
		}else{
			neededTimeStub = PERIOD_TIME_LIST.get(PERIOD_TIME_LIST.size() - periods);
		}
		return PERIOD_TIME_LIST.get(PERIOD_TIME_LIST.size() - 1) - neededTimeStub;
	}

	public static void putTimeCountStubAndGetMsg(int periods){
		double time = putTimeCountStub(periods);
		System.out.print("Current time period: " + time/1000 + "s");
		System.out.println(" | " + "now: " + new Date());
	}
}

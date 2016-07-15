package com.zlkj.thread;

import java.util.concurrent.Callable;

public class MyTask implements Callable<Integer> {
	private int upperBounds;
	
	public MyTask(int _upperBounds) {
		this.upperBounds = _upperBounds;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i <= upperBounds; i++){
			sum +=i;
		}
		return sum;
	}
	
}

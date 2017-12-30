package br.com.luciano.exameocp.threads;

import java.util.concurrent.RecursiveTask;

/**
 * 
 * @author Luciano Lima
 *
 */
public class SumArrayTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	
	private int [] array;
	private int min;
	private int max;
	
	public SumArrayTask(int [] array, int min, int max) {
		this.array = array;
		this.min = min;
		this.max = max;
	}

	@Override
	protected Integer compute() {
		int numElement = max - min + 1;
		
		if(numElement < 4) {
			int partialSum = 0;
			for(int i = min; i <= max; i++)
				partialSum += array[i];
			
			return partialSum;
		} 
		
		//500000
		int half = numElement / 2;
		
		SumArrayTask leftTask = new SumArrayTask(array, min, min + half);		
		SumArrayTask rightTask = new SumArrayTask(array, min + half + 1, max);
		
		leftTask.fork();
		
		int rightPartialSum = rightTask.compute();
		int leftPartialSum = leftTask.join();
		
		return leftPartialSum + rightPartialSum;
	}
	
}

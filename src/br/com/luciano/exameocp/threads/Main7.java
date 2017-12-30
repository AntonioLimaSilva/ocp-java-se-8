package br.com.luciano.exameocp.threads;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Main7 {

	public static void main(String[] args) {
		
		int array[] = new int[1000000];
		Arrays.fill(array, 1);
		
		SumArrayTask task = new SumArrayTask(array, 0, array.length - 1);
		
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		int sum = forkJoinPool.invoke(task);
		
		System.out.println("Result: " + sum);		
	}

}

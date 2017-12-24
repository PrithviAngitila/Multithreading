package org.knowledgehuunt;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Executiontest {
     private final static long range=1000000L;
	public void testRaceCondition(long nthreads) throws InterruptedException
	{
		
		//get the singleton executor instance through ExecutorEnum class
		//which ensures thread safety in multicore processors
		ExecutorEnum singletonExecutor=ExecutorEnum.EXECUTOR;
		ExecutorService executor=singletonExecutor.getExecutorService();
		
		//executor.submit() takes either runnable or callable interface
		//use runnable interface when workerthread doesnt return any data
		//use callabl interface to return data from worker thread
		
		//we can use lambda expressions to implement interfaces inplace
		
		
		
		int t;
		//create an instance to counter class
		Counter counter=new Counter();
		
		CompletableFuture<Void> result=null;
		//implement runnable interface using lamabda expresions
		for(t=0;t<nthreads;t++)
		{
			//submit task to thread pool using completablefuture by passing executor as parameter
			result=CompletableFuture.runAsync(()->counter.increment(),executor);
		}
	    //once all threads complete execution display the result
		result.thenAccept(res->
		{
		       //display results now     
			System.out.println("Expected Result:"+nthreads+" but obtained result:"+counter.getCount());
		});
	}
	
	public static void main(String[] args) {
               
		Executiontest executiontest=new Executiontest();
		System.out.println("");

		
		long start=10;
		for(start=10;start<=range;start*=10)
		{
		try {
				executiontest.testRaceCondition(start);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//shutdown the executor after completing all tasks
		ExecutorEnum singletonExecutor=ExecutorEnum.EXECUTOR;
		ExecutorService executor=singletonExecutor.getExecutorService();
		executor.shutdown();
	}

}

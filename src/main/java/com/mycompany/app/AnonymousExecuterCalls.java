package com.mycompany.app;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AnonymousExecuterCalls {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService es=Executors.newFixedThreadPool(2);
		Future<Integer> f=es.submit(new Callable<Integer>() {
	        public Integer call() throws Exception {
	        	Thread.sleep(5000);
	            return 2 * 2;
	        }
	    });
		
		Future<String> f2=es.submit(new Callable<String>() {
	        public String call() throws Exception {
	        	Thread.sleep(15000);
	            return "hello";
	        }
	    });
		
		System.out.println("MAIN before 1");
		Integer i=f.get();
		System.out.println("MAIN after 1");
		System.out.println("MAIN before 2");
		String str=f2.get();
		System.out.println("MAIN after 2 and EXIT");
		es.shutdown();
		
	}
}

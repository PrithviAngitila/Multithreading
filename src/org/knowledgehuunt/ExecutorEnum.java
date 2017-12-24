package org.knowledgehuunt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum ExecutorEnum {
EXECUTOR;
	
	private final ExecutorService executorService;
    private final int Nthreads=10;
	private ExecutorEnum() {
		this.executorService=Executors.newFixedThreadPool(Nthreads);
	}
	public ExecutorService getExecutorService() {
		return executorService;
	}
	
}

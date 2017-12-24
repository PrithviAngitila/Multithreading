package org.knowledgehuunt;

public class Counter {
	
//make the count variable volatile to make Threadsafe( all reads gets the latest value)
	private  int count;
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	//make the increment method synchronized to allow only one thread at a time.
	public synchronized void increment()
	{
		this.count++;
	}

}

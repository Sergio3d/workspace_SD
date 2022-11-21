
public class ThreadCounter implements Runnable {
	Counter c;
	int times;

	ThreadCounter(Counter c, int times)  { 
//1. Initialize the thread
		this.c=c;
		this.times=times;
	}

	@Override
	public void run() {

		for (int i = 1; i <= this.times; i++) {
			try {
				Thread.sleep(100); //wait 0,1 s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c.increment();
			System.out.println("Sum = " + c.getValue());
		}
	}


	public static void main(String[] args) throws Exception {

		int times = 10;

//2. Create a counter object
		Counter counter = new Counter() ;

//3. Create a thead1 that increment 10 times the counterº
		Thread thCounter1 = new Thread (new ThreadCounter(counter,times));
		
//4. start the counter thread 
		thCounter1.start();
//5. main waits for the counter thread to end.
		thCounter1.join();
//6. main thread prints the final value of the counter
		System.out.println("Sum Total = " + counter.getValue());
	}
}

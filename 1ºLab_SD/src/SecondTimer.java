
import java.util.Scanner;

public class SecondTimer implements Runnable {
// write a run method that counts the seconds passed as a parameter doing the following // task:
// sleep 1 second
// wake up, increments the number of seconds, prints it, and
// sleep again 1 second.

    private int seconds = 0;

    public void run() {
	//To be implemented by the student
    	Thread t = Thread.currentThread();
    	for(int i=0; i<=seconds;i++) {
	        try {
				t.sleep(1000);
				seconds += 1;
		        System.out.println("Ha pasado  " + seconds + "  segundo");
			} catch (InterruptedException e) {
				//e.printStackTrace();
				seconds += 1;
		        System.out.println("Al final han pasado  " + seconds + "  segundos");
				return;
			}
    	}
    	
    }

    public static void main(String args[]) {
   	 System.out.println ("Seconds to wait? ");
   	 Scanner in = new Scanner(System.in);
   	 int secondsToWait = in.nextInt();

   	 SecondTimer timer = new SecondTimer();
   	 Thread timerThread = new Thread(timer);

   	 timerThread.start();

   	 try {

   		 Thread.sleep(secondsToWait * 1000);

   		 timerThread.interrupt(); //Stop the timer
   	 } catch (InterruptedException e) {
   		 e.printStackTrace();
   	 }
    }
}

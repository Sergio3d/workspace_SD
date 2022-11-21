
public class TaskHello1 implements Runnable {
    public void run() {
    	Thread t = Thread.currentThread();
       System.out.println("Hello from thread " + t.getId());
       System.out.println( "THREAD Name: " + t.getName());
      	System.out.println( "id: " + t.getId());
      	System.out.println( "priority: " + t.getPriority());
      	System.out.println( "State: " + t.getState());
      	System.out.println( "Thread Group: " + t.getThreadGroup().getName());
      	System.out.println( "------------------ ");

    }

    public static void main(String args[]) {
		
		TaskHello1 taskHello = new TaskHello1();			
		Thread  thread1 = new Thread(taskHello);
		Thread  thread2 = new Thread(taskHello);
		thread1.start();
		thread2.start();					
    }
}


public class TaskHello implements Runnable {				//1
    public void run() {								//2
        System.out.println("Hello from a thread!");			//3
    }

    public static void main(String args[]) {
		//4
		TaskHello taskHello = new TaskHello();			//5
		Thread  threadHello = new Thread(taskHello);		//6
		threadHello.start();						//7
    }

}

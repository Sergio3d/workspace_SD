package Cliente;

/**************************************************************/
//FICHERO: ClienteUnaAgenda
/**************************************************************/
public class ClientAgendaAndTime implements Runnable{
	
	Time currentTime = new Time();
	Agenda phoneAgenda = new Agenda();
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new ClientAgendaAndTime());
		Thread thread2 = new Thread(new ClientAgendaAndTime());
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println(Thread.currentThread().toString()+"Server Current Time " + currentTime.getHour() + ":"+ currentTime.getMinute()+":"+ currentTime.getSeconds());
		phoneAgenda.asociar("Juan", 66756677);
		System.out.println(Thread.currentThread().toString()+"Telefono Juan = " + phoneAgenda.obtener("Juan"));
	}
}
package Cliente;

/**************************************************************/
//FICHERO: ClienteUnaAgenda
/**************************************************************/
public class ClientAgendaAndTime {
	public static void main(String[] args) {
		Time currentTime = new Time();
		System.out.println("Server Current Time " + currentTime.getHour() + ":"+ currentTime.getMinute()+":"+ currentTime.getSeconds());
		Agenda phoneAgenda = new Agenda();
		phoneAgenda.asociar("Juan", 66756677);
		System.out.println("Telefono Juan = " + phoneAgenda.obtener("Juan"));
	}
}
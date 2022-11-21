package Cliente;

/**************************************************************/
//FICHERO: ClienteUnaAgenda
/**************************************************************/
public class ClienteUnaAgenda{
	
	public static void main(String[] args) {
		Agenda phoneAgenda = new Agenda();
		Agenda passwdAgenda = new Agenda();
		phoneAgenda.asociar("Juan", 66756677);
		passwdAgenda.asociar("Moodle", 23323);
		phoneAgenda.asociar("Pepe", 644454456);
		System.out.println("Juan�s Phone = " + phoneAgenda.obtener("Juan"));
		System.out.println("Pepe�s Phone = " + phoneAgenda.obtener("Pepe"));
		System.out.println("Password Moodle = " + passwdAgenda.obtener("Moodle"));
	}
	
}
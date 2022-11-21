package Servidor;

/**************************************************************/
//FICHERO: Agenda
/**************************************************************/
import java.util.Hashtable;
public class Agenda implements IRepositorio {
	
	private Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
	
	public void asociar(String s, int v) {
		//Inserta una nueva tupla en la tabla hash
		ht.put(s, new Integer(v));
	}
	
	public int obtener(String s) {
		//Obtiene el valor asociado a la clave s
		return ((Integer) ht.get(s)).intValue();
	}
}
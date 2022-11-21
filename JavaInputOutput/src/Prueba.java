
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prueba {

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		boolean eof = false;
		String line = null;
		do {//eof windows = ^z . eof linux = ^D
		line = br.readLine();
		eof = (line == null);
		if (!eof) System.out.println(line);
		} while (!eof);
		System.out.println("fin de fichero");
		br.close();
		ir.close();
		}
	
}

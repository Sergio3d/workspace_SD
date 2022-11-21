import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prueba2 {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("./src/readme.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
		System.out.println(line);
		}
		br.close();
	}
}

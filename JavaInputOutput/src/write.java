import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class write {
	public static void main(String[] args) throws IOException {
	
		FileOutputStream outputStream = new FileOutputStream("MyFile.txt");
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
		BufferedWriter buffWriter = new BufferedWriter(outputStreamWriter);
		buffWriter.write("Xin chào");
		buffWriter.newLine();
		buffWriter.flush(); //use only when prompt output is needed.
		buffWriter.write("Hẹn gặp lại!");
		buffWriter.close();
		
		FileReader fr = new FileReader("MyFile.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while ((line = br.readLine()) != null) {
		System.out.println(line);
		}
		br.close();
	}
	
}

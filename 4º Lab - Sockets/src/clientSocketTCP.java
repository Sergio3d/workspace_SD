import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientSocketTCP {
	public static void main (String[] args){
		Socket socket;
		try {
			socket = new Socket("localhost", 10000);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//send to the server “how are you?”
			OutputStreamWriter or = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(or);
			bw.write("holi xdd");
			bw.newLine();
			bw.flush();
			
			//receive the answer from server
			InputStreamReader ir = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(ir);
			System.out.println(br.readLine());
			
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
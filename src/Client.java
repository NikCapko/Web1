import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	private static Socket socket;
	private static BufferedReader reader;
	private static BufferedReader in;
	private static BufferedWriter out;
	
	public static void main(String[] args) {
		try {		
			socket = new Socket("localhost", 12345);
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String clintString = reader.readLine();
			out.write(clintString + "\n");
			out.flush();

			String serverString = in.readLine();
			System.out.println(serverString);

			socket.close();
			reader.close();
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

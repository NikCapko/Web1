import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		System.out.println("Server start...");
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			Socket socket = serverSocket.accept();
			
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        String line = fromClient.readLine();
	        
	        InputData input = new InputData(line);
	        
	        PrintWriter toClient = new PrintWriter(socket.getOutputStream(), true);
	        toClient.println(input.getResult());
	        
			//System.out.println(input.getResult());
	        
			serverSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Server stop...");
	}
}

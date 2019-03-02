import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			String st = in.nextLine();
			
			Socket socket = new Socket("localhost", 12345);
			
			PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
			toServer.println(st);
			
			BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(fromServer.readLine());
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

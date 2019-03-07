import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static ServerSocket serverSocket;
	private static Socket socket;
	private static BufferedReader in;
	private static BufferedWriter out;

	public static void main(String[] args) {
		System.out.println("Server start...");
		try {
			serverSocket = new ServerSocket(12345, 1);
			socket = serverSocket.accept();

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while (true) {
				String number = in.readLine();
				if (number.equals("exit")) {
					break;
				}
				Convert convert = new Convert(number);
				out.write(convert.getResult() + "\n");
				out.flush();
			}
			socket.close();
			in.close();
			out.close();
			serverSocket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Server stop...");
	}
}
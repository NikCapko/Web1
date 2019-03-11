import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
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

            String s;

            while (true) {
                s = in.readLine();
                System.out.println("Получено " + s);
                if (s.equals("exit")) {
                    break;
                }
                System.out.println("Отправлено " + s);
                out.write(s + "\n");
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
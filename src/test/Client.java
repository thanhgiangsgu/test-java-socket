import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/*package test;*/

/**
 *
 * @author GIANG
 */
public class Client {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int PORT_NUMBER = 12345;

        try (Socket socket = new Socket(SERVER_IP, PORT_NUMBER);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to server. Type a message and press Enter to send.");

            // Luồng đọc dữ liệu từ console
            String message;
            while ((message = reader.readLine()) != null) {
                // Gửi dữ liệu đến server
                writer.println(message);

                // Kết thúc nếu nhập "exit"
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
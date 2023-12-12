import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT_NUMBER = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("Server is waiting for client connection on port " + PORT_NUMBER);

            // Chờ đợi kết nối từ client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Tạo luồng để đọc dữ liệu từ client
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Đọc dữ liệu từ client và in ra màn hình
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
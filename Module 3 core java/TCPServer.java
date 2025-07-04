import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");
        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Client: " + input);
            System.out.print("Server: ");
            out.println(userInput.readLine());
        }
        socket.close();
        server.close();
    }
}

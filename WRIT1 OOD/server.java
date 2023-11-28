import java.io.*;
import java.net.*;
import java.util.concurrent.*;


public class server {
    //james editing 
    private static final int PORT = 444; // Change this to your desired port number
    private static final int MAX_CLIENTS = 4;
    private static ExecutorService executor = Executors.newFixedThreadPool(MAX_CLIENTS);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                executor.submit(new clientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


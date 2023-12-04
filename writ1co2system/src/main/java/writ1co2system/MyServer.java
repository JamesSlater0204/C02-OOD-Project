package writ1co2system;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private ServerSocket serverSocket;
    private final int MAX_CONNECTIONS = 4;
    private int currentConnections = 0;

    public MyServer() {
        try {
            serverSocket = new ServerSocket(5000); // Replace with your desired port number
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                if (currentConnections < MAX_CONNECTIONS) {
                    currentConnections++;
                    System.out.println("new connection.");
                } 
                else 
                {
                    System.out.println("Max connections reached. Connection rejected.");
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean hasSpaceForConnection() {
        return currentConnections < MAX_CONNECTIONS;
    }
    
}
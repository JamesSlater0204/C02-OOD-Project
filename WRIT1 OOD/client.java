import java.io.*;
import java.net.*;

public class client {
    private static final String SERVER_IP = "localhost"; // Change this to the server's IP address
    private static final int SERVER_PORT = 444; // Change this to the server's port number

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            // Server greeting
            System.out.println(reader.readLine());

            // Collecting user input
            System.out.print("Enter User ID: ");
            String userID = consoleReader.readLine();
            System.out.print("Enter Postcode: ");
            String postcode = consoleReader.readLine();
            System.out.print("Enter CO2 Concentration (ppm): ");
            String co2PPM = consoleReader.readLine();

            // Sending data to server
            writer.println(userID + "," + postcode + "," + co2PPM);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



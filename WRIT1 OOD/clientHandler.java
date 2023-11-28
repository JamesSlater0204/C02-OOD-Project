import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class clientHandler implements Runnable {
    private Socket clientSocket;

    public clientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv", true))) {

            // Server greeting
            writer.write("Connected to the server. Please provide the following details:\n");
            writer.flush();

            // Collecting user input
            writer.write("Enter User ID: ");
            writer.flush();
            String userID = reader.readLine();
            writer.write("Enter Postcode: ");
            writer.flush();
            String postcode = reader.readLine();
            writer.write("Enter CO2 Concentration (ppm): ");
            writer.flush();
            String co2PPM = reader.readLine();

            // Recording data to CSV file
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String data = timestamp + "," + userID + "," + postcode + "," + co2PPM + "\n";
            synchronized (server.class) {
                writer.write(data);
                writer.flush();
            }

            // Closing the connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

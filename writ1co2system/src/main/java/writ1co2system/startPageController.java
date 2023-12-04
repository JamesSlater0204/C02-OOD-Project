package writ1co2system;

import java.io.IOException;
import java.net.Socket;

import javafx.fxml.FXML;

public class startPageController {

    @FXML
    private void connectToServer() throws IOException {
        MyServer server = App.getServerInstance();

        boolean hasSpace = server.hasSpaceForConnection();

        if(hasSpace)
        {
            Socket socket = new Socket("localhost", 5000);
            App.setRoot("accessPage");
        }
    }
}

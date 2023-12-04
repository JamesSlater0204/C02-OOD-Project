package writ1co2system;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class accessPageController {
    @FXML
    private TextField txtUserid;

    @FXML
    private TextField txtPostCode;

    @FXML
    private TextField txtCo2Conc;

    @FXML
    private Label txtMessage;
    
    @FXML
    private void writeData() throws IOException 
    {
        String userID = txtUserid.getText();
        String postcode = txtPostCode.getText();
        float co2Concentration = Float.parseFloat(txtCo2Conc.getText());

        clientHandler handler = new clientHandler(userID); // Create an instance

        // Call the storeDataCSV method
        boolean success = handler.storeDataCSV(postcode, co2Concentration);

        if (success) {
            txtMessage.setText("Data stored successfully!");
            txtMessage.setStyle("-fx-text-fill: red;");
        } else {
            txtMessage.setText("Failed to store data.");
            txtMessage.setStyle("-fx-text-fill: red;");
        }
    }
}
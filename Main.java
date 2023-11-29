
public class Main {
        @Override
        public void start(Stage primaryStage) throws Exception 
        {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("path/to/your/Sample.fxml"));
    
            // Create a scene
            Scene scene = new Scene(root);
    
            // Set the scene to the stage
            primaryStage.setScene(scene);
    
            // Set the window title
            primaryStage.setTitle("My JavaFX Application");
    
            // Show the stage
            primaryStage.show();
        }
    
        public static void main(String[] args) 
        {
            launch(args);
        }    
}

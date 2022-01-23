package be.fiiw.exomeda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    public static int WINDOW_WIDTH = 1280;
    public static int WINDOW_HEIGHT = 720;

    
     @Override
     public void start(Stage stage) {
    try {
    Parent root = FXMLLoader.load(getClass().getResource("StartingScreenFXML.fxml"));
        scene = new Scene(root, App.WINDOW_WIDTH, App.WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("Exomeda - TheGame");
        stage.show();
        stage.setResizable(false);
        
        stage.setOnCloseRequest(e -> {
            e.consume();
            stage.close();
            System.exit(0);
        });
    
  } catch(Exception e) {
   e.printStackTrace();
  }
 } 

 public static void App(String[] args) {
  launch(args);
 }

}
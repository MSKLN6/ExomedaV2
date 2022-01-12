package be.fiiw.exomeda;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import model.Exomeda;
import view.ExomedaView;

public class ExomedaFXMLController {
    
    private Exomeda model;
    private ExomedaView view;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane exomeda;

    @FXML
    public void initialize() {
        model = new Exomeda();
        view  = new ExomedaView(model);

    }

}

package sample;

import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
        import java.util.ResourceBundle;

        //Controlador de la segunda pantalla
public class Secundario {

    @FXML
    private Label txt_nombre2;

    //Método que rescata el valor y lo coloca en el Label de la segunda pantalla
    public void setData(String texto){
        txt_nombre2.setText(texto);
    }


    @FXML
    private void salir(ActionEvent actionEvent) {
        Platform.exit();
    }
}
package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//Controlador de la primera pantalla
public class Principal implements Initializable
{
    String resp;


    @FXML
    private TextField txt_nombre;
    @FXML
    private Button btn_siguiente;

    @FXML
    private void ir_secundario() {
        ir_secundario();
    }


    @FXML
    private void ir_secundario(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Secundario.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String texto = txt_nombre.getText();
        double doubleNumber = Double.parseDouble(texto);
        //Sólo se admiten números positivos
        if (doubleNumber < 0){
            resp = "El número debe ser positivo";
        }
        else{
            //Llamando a la clase que realiza las conversiones
            NumberToLetterConverter myConverter;
            myConverter = new NumberToLetterConverter();
            //El resultado se deposita en la variable resp
            resp = myConverter.convertNumberToLetter( doubleNumber);
        }
        ((Secundario) fxmlLoader.getController()).setData(resp);
    }

    //Controla la barra de acción de la ventana
    @FXML
    private void salir(ActionEvent actionEvent){
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}



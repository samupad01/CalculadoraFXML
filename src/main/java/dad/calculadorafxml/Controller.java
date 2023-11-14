package dad.calculadorafxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private GridPane view;

    @FXML private TextField pantalla;

    // Botones numéricos (0-9)
    @FXML private Button btn0;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Button btn9;

    // Botones de operaciones
    @FXML private Button btnc;
    @FXML private Button btnce;
    @FXML private Button btncoma;
    @FXML private Button btndivide;
    @FXML private Button btnequal;
    @FXML private Button btnmultiply;
    @FXML private Button btnplus;
    @FXML private Button btnsubstrate;

    private Calculadora calculadora = new Calculadora();
    //Carga de la vista por FXMLLoader
    public Controller() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pantalla.setText(calculadora.getPantalla());
    }

    @FXML
    private void insertar(ActionEvent e) {
        String valor = ((Button)e.getSource()).getText();
        char digito = valor.charAt(0);
        calculadora.insertar(digito);
        actualizarPantalla();
    }

    @FXML
    private void operar(ActionEvent e) {
        String operacion = ((Button)e.getSource()).getText();
        char operador = operacion.charAt(0);
        calculadora.operar(operador);
        actualizarPantalla();
    }

    @FXML
    private void borrar(ActionEvent event) {
        calculadora.borrar();
        actualizarPantalla();
    }

    @FXML
    private void borrarTodo(ActionEvent event) {
        calculadora.borrarTodo();
        actualizarPantalla();
    }

    @FXML
    private void insertarComa(ActionEvent event) {
        calculadora.insertarComa();
        actualizarPantalla();
    }

    private void actualizarPantalla() {
        pantalla.setText(calculadora.getPantalla());
    }

    public GridPane getView() {
        return view;
    }
}




package dad.calculadorafxml;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Controller controller = new Controller();
        
        Scene scene = new Scene(controller.getView());
        primaryStage.setTitle("Calculadora FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


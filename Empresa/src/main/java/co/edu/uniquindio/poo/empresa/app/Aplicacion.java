package co.edu.uniquindio.poo.empresa.app;


import co.edu.uniquindio.poo.empresa.model.Empleado;
import co.edu.uniquindio.poo.empresa.model.Empresa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;



public class Aplicacion extends Application{

    private Stage primaryStage;
    public static Empresa empresa= new Empresa("UQ");



    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Empresa UQ");
        openViewPrincipal();
    }

    private void openViewPrincipal(){
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("iniciosesion.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            InicioSesionViewController inicioSesionViewController = loader.getController();
            inicioSesionViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

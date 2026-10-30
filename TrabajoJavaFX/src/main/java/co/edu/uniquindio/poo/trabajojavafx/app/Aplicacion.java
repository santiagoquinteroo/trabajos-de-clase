package co.edu.uniquindio.poo.trabajojavafx.app;

import co.edu.uniquindio.poo.trabajojavafx.model.Biblioteca;
import co.edu.uniquindio.poo.trabajojavafx.model.Categoria;
import co.edu.uniquindio.poo.trabajojavafx.model.Libro;
import co.edu.uniquindio.poo.trabajojavafx.viewController.LibroViewController;
import co.edu.uniquindio.poo.trabajojavafx.viewController.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {

    private Stage primaryStage;
    public static Biblioteca biblioteca = new Biblioteca("Biblioteca UQ");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Biblioteca");
        inicializarData();
        openViewPrincipal();
    }

    public static void main(String[] args) {
        launch();
    }

    public void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("menuPrincipal.fxml"));
            VBox rootLayout = (VBox) loader.load();
            MenuController menuController = loader.getController();
            menuController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCrudLibro() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource("crudLibro.fxml"));
            BorderPane rootLayout = (BorderPane) loader.load();
            LibroViewController libroViewController = loader.getController();
            libroViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.centerOnScreen();
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // servicios
    public void inicializarData() {
        biblioteca.agregarLibro(new Libro("Effective Java", "Joshua Bloch", "978-0-13-468599-1",
                2018, Categoria.TECNOLOGIA, true));
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez",
                "978-0-307-47472-8", 1967, Categoria.NOVELA, false));
        biblioteca.agregarLibro(new Libro("Cosmos", "Carl Sagan", "978-0-345-53943-4",
                1980, Categoria.CIENCIA, true));
    }
}

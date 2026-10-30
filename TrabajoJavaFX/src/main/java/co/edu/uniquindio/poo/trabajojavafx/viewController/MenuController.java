package co.edu.uniquindio.poo.trabajojavafx.viewController;

import co.edu.uniquindio.poo.trabajojavafx.app.Aplicacion;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuController {
    private Aplicacion app;

    @FXML
    private Label lblResumen;

    @FXML
    private Button btnAbrirCatalogo;

    @FXML
    private Button btnSalir;

    @FXML
    void onAbrirCatalogo() {
        app.openCrudLibro();
    }

    @FXML
    void onSalir() {
        Platform.exit();
    }

    @FXML
    void initialize() {
    }

    public void setApp(Aplicacion app) {
        this.app = app;
        int total = Aplicacion.biblioteca.getListaLibros().size();
        lblResumen.setText("Libros registrados: " + total);
    }
}

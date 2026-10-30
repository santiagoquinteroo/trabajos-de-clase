module co.edu.uniquindio.poo.trabajojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens co.edu.uniquindio.poo.trabajojavafx to javafx.fxml;
    exports co.edu.uniquindio.poo.trabajojavafx;
}
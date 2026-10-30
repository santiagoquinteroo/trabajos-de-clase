module co.edu.uniquindio.poo.trabajojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.trabajojavafx to javafx.fxml;
    exports co.edu.uniquindio.poo.trabajojavafx.app;
    exports co.edu.uniquindio.poo.trabajojavafx.viewController;
    opens co.edu.uniquindio.poo.trabajojavafx.viewController to javafx.fxml;
}
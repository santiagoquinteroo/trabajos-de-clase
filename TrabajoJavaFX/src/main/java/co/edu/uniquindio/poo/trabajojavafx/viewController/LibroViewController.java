package co.edu.uniquindio.poo.trabajojavafx.viewController;

import co.edu.uniquindio.poo.trabajojavafx.app.Aplicacion;
import co.edu.uniquindio.poo.trabajojavafx.controller.LibroController;
import co.edu.uniquindio.poo.trabajojavafx.model.Biblioteca;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import co.edu.uniquindio.poo.trabajojavafx.model.Categoria;
import co.edu.uniquindio.poo.trabajojavafx.model.Libro;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.time.Year;
import java.util.Optional;
import java.util.regex.Pattern;

public class LibroViewController {

    private static final String ESTILO_OK = "estado-ok";
    private static final String ESTILO_ERROR = "estado-error";
    private static final String ESTILO_INFO = "estado-info";

    private static final int ANIO_MINIMO = 1450;
    private static final Pattern PATRON_ISBN = Pattern.compile("^[0-9][0-9-]{8,15}[0-9Xx]$");

    private LibroController libroController;
    private Aplicacion app;

    private final ObservableList<Libro> listaLibros = FXCollections.observableArrayList();
    private FilteredList<Libro> librosFiltrados;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtTitulo;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtAnio;

    @FXML
    private ComboBox<Categoria> cmbCategoria;

    @FXML
    private CheckBox chkDisponible;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnVolver;

    @FXML
    private TableView<Libro> tblLibros;

    @FXML
    private TableColumn<Libro, String> tbcIsbn;

    @FXML
    private TableColumn<Libro, String> tbcTitulo;

    @FXML
    private TableColumn<Libro, String> tbcAutor;

    @FXML
    private TableColumn<Libro, Integer> tbcAnio;

    @FXML
    private TableColumn<Libro, String> tbcCategoria;

    @FXML
    private TableColumn<Libro, String> tbcDisponible;

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblTotal;


    @FXML
    void onAgregar() {
        agregarLibro();
    }

    @FXML
    void onActualizar() {
        actualizarLibro();
    }

    @FXML
    void onEliminar() {
        eliminarLibro();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
        mostrarEstado("Formulario limpio. Puede registrar un nuevo libro.", ESTILO_INFO);
    }

    @FXML
    void onVolver() {
        app.openViewPrincipal();
    }

    @FXML
    void initialize() {
        libroController = new LibroController(Aplicacion.biblioteca);
        initView();
    }


    private void initView() {
        librosFiltrados = new FilteredList<>(listaLibros, libro -> true);

        initDataBinding();

        cmbCategoria.setItems(FXCollections.observableArrayList(Categoria.values()));
        chkDisponible.setSelected(true);
        txtAnio.setTextFormatter(new TextFormatter<String>(
                cambio -> cambio.getControlNewText().matches("\\d{0,4}") ? cambio : null));

        obtenerLibros();
        SortedList<Libro> librosOrdenados = new SortedList<>(librosFiltrados);
        librosOrdenados.comparatorProperty().bind(tblLibros.comparatorProperty());
        tblLibros.setItems(librosOrdenados);
        tblLibros.setPlaceholder(new Label("No hay libros que coincidan con la búsqueda."));

        configurarEstadoBotones();
        listenerBusqueda();
        listenerSelection();
        actualizarContador();
        mostrarEstado("Listo. Seleccione un libro de la tabla o complete el formulario.", ESTILO_INFO);
    }

    private void initDataBinding() {
        tbcIsbn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getIsbn()));
        tbcTitulo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTitulo()));
        tbcAutor.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAutor()));
        // SimpleObjectProperty para manejar el Integer correctamente
        tbcAnio.setCellValueFactory(c -> new SimpleObjectProperty<>(c.getValue().getAnioPublicacion()));
        tbcCategoria.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCategoria().toString()));
        tbcDisponible.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().isDisponible() ? "Sí" : "No"));
    }

    private void obtenerLibros() {
        listaLibros.setAll(libroController.getListaLibros());
    }


    private void configurarEstadoBotones() {
        BooleanBinding haySeleccion = tblLibros.getSelectionModel().selectedItemProperty().isNotNull();
        btnAgregar.disableProperty().bind(haySeleccion);
        txtIsbn.disableProperty().bind(haySeleccion);
        btnActualizar.disableProperty().bind(haySeleccion.not());
        btnEliminar.disableProperty().bind(haySeleccion.not());
    }

    private void listenerSelection() {
        tblLibros.getSelectionModel().selectedItemProperty().addListener((obs, anterior, nuevo) -> {
            if (nuevo != null) {
                mostrarInformacionLibro(nuevo);
            }
        });
    }

    private void listenerBusqueda() {
        txtBuscar.textProperty().addListener((obs, anterior, nuevo) -> aplicarFiltro());
    }


    private void agregarLibro() {
        if (!validarFormulario()) {
            return;
        }
        Libro libro = construirLibro();
        String resultado = libroController.crearLibro(libro);
        if (resultado.equals("Libro agregado con éxito")) {
            listaLibros.add(libro);
            limpiarCampos();
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso",
                    "Ya existe un libro registrado con el ISBN " + libro.getIsbn() + ".");
        }
    }

    private void eliminarLibro() {
        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Seleccione en la tabla el libro que desea eliminar.");
            return;
        }
        String resultado = libroController.eliminarLibro(seleccionado);
        if (resultado.equals("Libro eliminado con éxito")) {
            listaLibros.remove(seleccionado);
            limpiarSeleccion();
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", resultado);
        }
    }

    private void actualizarLibro() {
        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            reportarError("Sin selección", "Seleccione en la tabla el libro que desea actualizar.", tblLibros);
            return;
        }
        if (!validarFormulario()) {
            return;
        }
        Libro datos = construirLibro();
        if (libroController.actualizarLibro(seleccionado.getIsbn(), datos)) {
            // el modelo modifica el mismo objeto que muestra la tabla
            tblLibros.refresh();
            tblLibros.sort();
            aplicarFiltro();
            limpiarSeleccion();
            mostrarEstado("Libro \"" + datos.getTitulo() + "\" actualizado correctamente.", ESTILO_OK);
        } else {
            reportarError("No se pudo actualizar",
                    "El libro ya no existe o el ISBN pertenece a otro registro.", txtIsbn);
        }
    }




    private Libro construirLibro() {
        return new Libro(
                txtTitulo.getText().trim(),
                txtAutor.getText().trim(),
                txtIsbn.getText().trim(),
                Integer.parseInt(txtAnio.getText().trim()),
                cmbCategoria.getValue(),
                chkDisponible.isSelected());
    }

    private void mostrarInformacionLibro(Libro libro) {
        txtIsbn.setText(libro.getIsbn());
        txtTitulo.setText(libro.getTitulo());
        txtAutor.setText(libro.getAutor());
        txtAnio.setText(String.valueOf(libro.getAnioPublicacion()));
        cmbCategoria.setValue(libro.getCategoria());
        chkDisponible.setSelected(libro.isDisponible());
        mostrarEstado("Editando \"" + libro.getTitulo() + "\". Modifique los campos y pulse Actualizar.",
                ESTILO_INFO);
    }

    private void limpiarSeleccion() {
        tblLibros.getSelectionModel().clearSelection();
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtIsbn.clear();
        txtTitulo.clear();
        txtAutor.clear();
        txtAnio.clear();
        cmbCategoria.setValue(null);
        chkDisponible.setSelected(true);
    }


    private boolean validarFormulario() {
        String isbn = txtIsbn.getText().trim();
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String anio = txtAnio.getText().trim();

        if (isbn.isEmpty()) {
            return rechazar("El ISBN es obligatorio.", txtIsbn);
        }
        if (!PATRON_ISBN.matcher(isbn).matches()) {
            return rechazar("El ISBN debe tener entre 10 y 17 caracteres: solo dígitos y guiones "
                    + "(la X únicamente al final).", txtIsbn);
        }
        if (titulo.isEmpty()) {
            return rechazar("El título es obligatorio.", txtTitulo);
        }
        if (titulo.length() > 100) {
            return rechazar("El título no puede superar los 100 caracteres.", txtTitulo);
        }
        if (autor.isEmpty()) {
            return rechazar("El autor es obligatorio.", txtAutor);
        }
        if (autor.length() > 80) {
            return rechazar("El nombre del autor no puede superar los 80 caracteres.", txtAutor);
        }
        if (anio.isEmpty()) {
            return rechazar("El año de publicación es obligatorio.", txtAnio);
        }
        int anioActual = Year.now().getValue();
        try {
            int valor = Integer.parseInt(anio);
            if (valor < ANIO_MINIMO || valor > anioActual) {
                return rechazar("El año debe estar entre " + ANIO_MINIMO + " y " + anioActual + ".", txtAnio);
            }
        } catch (NumberFormatException e) {
            return rechazar("El año de publicación debe ser un número entero.", txtAnio);
        }
        if (cmbCategoria.getValue() == null) {
            return rechazar("Seleccione una categoría.", cmbCategoria);
        }
        return true;
    }

    private boolean rechazar(String mensaje, Control campo) {
        reportarError("Datos no válidos", mensaje, campo);
        return false;
    }


    private void reportarError(String titulo, String mensaje, Control campo) {
        mostrarEstado("Error: " + mensaje, ESTILO_ERROR);
        mostrarAlerta(Alert.AlertType.WARNING, titulo, mensaje);
        if (campo != null) {
            campo.requestFocus();
        }
    }

    private void mostrarEstado(String mensaje, String estilo) {
        lblEstado.getStyleClass().removeAll(ESTILO_OK, ESTILO_ERROR, ESTILO_INFO);
        lblEstado.getStyleClass().add(estilo);
        lblEstado.setText(mensaje);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }


    private void aplicarFiltro() {
        String texto = txtBuscar.getText() == null ? "" : txtBuscar.getText().trim().toLowerCase();
        librosFiltrados.setPredicate(libro -> texto.isEmpty()
                || libro.getIsbn().toLowerCase().contains(texto)
                || libro.getTitulo().toLowerCase().contains(texto)
                || libro.getAutor().toLowerCase().contains(texto));
        actualizarContador();
    }

    private void actualizarContador() {
        lblTotal.setText("Mostrando " + librosFiltrados.size() + " de " + listaLibros.size() + " libros");
    }

    public void setApp(Aplicacion app) {
        this.app = app;
    }

}

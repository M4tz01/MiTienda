package com.example.mitienda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController {

    // Controles del Formulario de Productos [cite: 48]
    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private ComboBox<String> cbCategoria;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtStock;
    @FXML private ComboBox<String> cbEstado;

    // Controles de la Tabla de Productos
    @FXML private TableView<Producto> tblProductos;
    @FXML private TableColumn<Producto, String> colCodigo;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colCategoria;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;
    @FXML private TableColumn<Producto, String> colEstado;

    // Colección observable vinculada a la tabla
    private ObservableList<Producto> listaProductos;

    @FXML
    public void initialize() {
        // 1. Configurar elementos de los ComboBoxes [cite: 51, 54]
        cbCategoria.getItems().addAll("Calzado", "Ropa", "Accesorios");
        cbEstado.getItems().addAll("Activo", "Inactivo");

        // 2. Mapear las columnas con las propiedades de la entidad Producto
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // 3. Inicializar la lista con los registros exactos de la captura
        listaProductos = FXCollections.observableArrayList(
                new Producto("P001", "Zapato Deportivo", "Calzado", 35.00, 20, "Activo"),
                new Producto("P002", "Camisa Manga Larga", "Ropa", 25.00, 15, "Activo"),
                new Producto("P003", "Jean Clásico", "Ropa", 40.00, 10, "Activo"),
                new Producto("P004", "Gorra Deportiva", "Accesorios", 12.00, 30, "Activo"),
                new Producto("P005", "Cinturón de Cuero", "Accesorios", 18.00, 25, "Inactivo")
        );
        tblProductos.setItems(listaProductos);

        // 4. Listener para transferir información de la tabla al formulario al seleccionar una fila
        tblProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                txtCodigo.setText(newSel.getCodigo());
                txtNombre.setText(newSel.getNombre());
                cbCategoria.setValue(newSel.getCategoria());
                txtPrecio.setText(String.valueOf(newSel.getPrecio()));
                txtStock.setText(String.valueOf(newSel.getStock()));
                cbEstado.setValue(newSel.getEstado());

                txtCodigo.setDisable(true); // Se bloquea el código para proteger la clave primaria
            }
        });
    }

    @FXML
    private void handleGuardar() { // Acción del botón Guardar [cite: 58]
        try {
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String categoria = cbCategoria.getValue();

            if (codigo.isEmpty() || nombre.isEmpty() || categoria == null || cbEstado.getValue() == null) {
                return; // Validación simple de campos requeridos
            }

            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());
            String estado = cbEstado.getValue();

            listaProductos.add(new Producto(codigo, nombre, categoria, precio, stock, estado));
            handleLimpiar();
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato numérico incorrecto en Precio o Stock.");
        }
    }

    @FXML
    private void handleActualizar() { // Acción del botón Actualizar [cite: 59]
        Producto seleccionado = tblProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                // Modificar propiedades observables directamente
                seleccionado.nombreProperty().set(txtNombre.getText());
                seleccionado.categoriaProperty().set(cbCategoria.getValue());
                seleccionado.precioProperty().set(Double.parseDouble(txtPrecio.getText()));
                seleccionado.stockProperty().set(Integer.parseInt(txtStock.getText()));
                seleccionado.estadoProperty().set(cbEstado.getValue());

                tblProductos.refresh(); // Actualiza visualmente el contenido
                handleLimpiar();
            } catch (NumberFormatException e) {
                System.out.println("Error: Parámetros numéricos no válidos.");
            }
        }
    }

    @FXML
    private void handleEliminar() { // Acción del botón Eliminar [cite: 60]
        Producto seleccionado = tblProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaProductos.remove(seleccionado);
            handleLimpiar();
        }
    }

    @FXML
    private void handleLimpiar() { // Acción de los botones Nuevo y Limpiar [cite: 57, 61]
        txtCodigo.clear();
        txtCodigo.setDisable(false); // Reactivar campo clave para nuevos registros
        txtNombre.clear();
        cbCategoria.setValue(null);
        txtPrecio.clear();
        txtStock.clear();
        cbEstado.setValue(null);
        tblProductos.getSelectionModel().clearSelection();
    }
}
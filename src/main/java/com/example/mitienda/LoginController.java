package com.example.mitienda;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasena;
    @FXML private ComboBox<String> cbRol;
    @FXML private Button btnIngresar;

    @FXML
    public void initialize() {
        // Llenar el ComboBox de roles al arrancar [cite: 27, 30, 32, 34]
        cbRol.getItems().addAll("Administrador", "Vendedor", "Cajero");
    }

    @FXML
    private void handleLogin() {
        String user = txtUsuario.getText();
        String pass = txtContrasena.getText();
        String rol = cbRol.getValue();

        // Validación quemada exigida por la rúbrica
        if ("admin".equals(user) && "1234".equals(pass) && "Administrador".equals(rol)) {
            try {
                // 1. Obtener la ventana actual de login y cerrarla
                Stage currentStage = (Stage) btnIngresar.getScene().getWindow();
                currentStage.close();

                // 2. Cargar la vista del Dashboard desde los recursos internos
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
                Parent root = loader.load();

                // 3. Inicializar y lanzar la nueva ventana principal
                Stage stage = new Stage();
                stage.setTitle("MiTienda - Sistema de Ventas");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                mostrarAlerta("Error de Sistema", "No se pudo cargar el Dashboard.", Alert.AlertType.ERROR);
                e.printStackTrace();
            }
        } else {
            mostrarAlerta("Acceso Denegado", "Usuario, contraseña o rol inválidos.", Alert.AlertType.WARNING);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
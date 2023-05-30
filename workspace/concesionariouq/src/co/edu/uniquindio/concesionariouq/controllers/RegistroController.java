package co.edu.uniquindio.concesionariouq.controllers;

import java.io.File;
import java.io.IOException;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.UsuarioEncontradoException;
import co.edu.uniquindio.concesionariouq.model.Empleado;
import co.edu.uniquindio.concesionariouq.model.TipoPersona;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class RegistroController {

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNombre;

	@FXML
	private PasswordField txtContrasena;

	@FXML
	private Hyperlink link;

	@FXML
	private TextField txtRespuesta;

	@FXML
	private TextField txtEmail;

	@FXML
	private ComboBox<String> comboTipoEmpleado;

	@FXML
	private Button btnElegirImagen;

	@FXML
	private ImageView imagenEmpleado;

	private String id;

	public RegistroController(String id) {
		this.id = id;
	}

	@FXML
	void initialize() {
		txtId.setText(id == null ? "" : id);
		comboTipoEmpleado.setItems(FXCollections
				.observableArrayList(new String[] { TipoPersona.EMPLEADO.getText(), TipoPersona.ADMIN.getText() }));
	}

	@FXML
	void volverEvent(ActionEvent event) {
		irIniciarSesionAction();
	}

	@FXML
	void elegirImagenEvent(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(new ExtensionFilter("Archivos de imagen", "*.jpg", "*.jpeg", "*.png"));
		File archivo = chooser.showOpenDialog(mainPane.getScene().getWindow());
		if (archivo == null)
			return;
		Image image = new Image(archivo.toURI().toString());
		imagenEmpleado.setImage(image);
		btnElegirImagen.setText("Abrir vista previa");
	}

	@FXML
	void registrarEvent(ActionEvent event) {
		registrarAction();
	}

	@FXML
	void irIniciarSesionEvent(ActionEvent event) {
		irIniciarSesionAction();
	}

	private void registrarAction() {
		try {
			ModelFactoryController.getInstance().agregarEmpleado(new Empleado(txtId.getText(), txtNombre.getText(),
					txtContrasena.getText(), txtEmail.getText(), txtRespuesta.getText(), true, null));
			FxUtility.mostrarMensaje("Confirmacion", "Has sido registrad@ con exito", "Has sido registrad@ con exito",
					AlertType.CONFIRMATION);
		} catch (UsuarioEncontradoException | NullException | AtributosFaltantesException e) {
			FxUtility.mostrarMensaje("Advertencia", "No te has podido registrar", e.getMessage(), AlertType.ERROR);
		}
	}

	private void irIniciarSesionAction() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/login.fxml"));
		LoginPageController controller = new LoginPageController(txtId.getText());
		loader.setController(controller);
		try {
			Stage stage = (Stage) mainPane.getScene().getWindow();
			stage.setScene(new Scene(loader.load(), 600, 440));
			stage.centerOnScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

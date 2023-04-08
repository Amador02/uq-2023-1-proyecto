package co.edu.uniquindio.concesionariouq.view.login;

import co.edu.uniquindio.concesionariouq.controllers.ControlLogin;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelLogin extends BorderPane {
	public PanelLogin(Stage stage) {
		VBox box = new VBox(20);
		TextField tfIdentificacion = new TextField("");
		PasswordField tfContrasena = new PasswordField();
		Label btnEntrar = new Label("Entrar");
		Label btnOlvidaste = new Label("�Olvidaste tu contrase�a?");

		box.getChildren().add(UtilPane.generarHBox("Escribe tu identificaci�n:", tfIdentificacion));
		box.getChildren().add(UtilPane.generarHBox("Escribe tu contrase�a:", tfContrasena));
		box.getChildren().add(btnEntrar);
		box.getChildren().add(btnOlvidaste);
		setCenter(box);
		btnEntrar.setOnMouseReleased(
				e -> ControlLogin.entrar(stage, tfIdentificacion.getText(), tfContrasena.getText()));
	}
}

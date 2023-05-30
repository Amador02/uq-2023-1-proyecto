package co.edu.uniquindio.concesionariouq.model;

import javafx.scene.image.Image;

public class Empleado extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String contrasena;
	protected String email;
	protected String respuestaDeSeguridad;
	protected Boolean estaActivo;
	protected Image imagen;

	/**
	 * Este es el constructor principal de la clase {@link Empleado}
	 * 
	 * @param id
	 * @param nombre
	 * @param contrasena
	 * @param email
	 * @param respuestaDeSeguridad
	 * @param estaActivo
	 * @param imagen
	 */
	public Empleado(String id, String nombre, String contrasena, String email, String respuestaDeSeguridad,
			Boolean estaActivo, Image imagen) {
		super(id, nombre);
		this.contrasena = contrasena;
		this.email = email;
		this.respuestaDeSeguridad = respuestaDeSeguridad;
		this.estaActivo = estaActivo;
		this.imagen = imagen;
	}

	@Override
	public boolean atributosLlenos() {
		return super.atributosLlenos() && contrasena != null && email != null && respuestaDeSeguridad != null
				&& !contrasena.isEmpty() && !email.isEmpty() && !respuestaDeSeguridad.isEmpty();
	}

	@Override
	public TipoPersona getTipoPersona() {
		return TipoPersona.EMPLEADO;
	}

	/**
	 * Determina si el empleado está activo o no
	 * 
	 * @return
	 */
	public boolean isActivo() {
		return estaActivo;
	}

	public void setIsActivo(boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRespuestaDeSeguridad() {
		return respuestaDeSeguridad;
	}

	public void setRespuestaDeSeguridad(String respuestaDeSeguridad) {
		this.respuestaDeSeguridad = respuestaDeSeguridad;
	}

	public Boolean getEstaActivo() {
		return estaActivo;
	}

	public void setEstaActivo(Boolean estaActivo) {
		this.estaActivo = estaActivo;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return String.format(
				"Empleado [id=%s, nombre=%s, contrasena=%s, email=%s, respuestaDeSeguridad=%s, estaActivo=%s, imagen=%s]",
				id, nombre, contrasena, email, respuestaDeSeguridad, estaActivo, imagen);
	}

}
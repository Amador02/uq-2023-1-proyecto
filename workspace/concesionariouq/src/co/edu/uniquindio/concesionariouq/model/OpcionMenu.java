package co.edu.uniquindio.concesionariouq.model;

public enum OpcionMenu {
	AGREGAR_VEHICULO("Agregar Vehiculo", 1), AGREGAR_CLIENTE("Agregar Cliente", 2),
	COMPRAR_VEHICULO("Comprar Vehiculo", 3), ALQUILAR_VEHICULO("Alquilar Vehiculo", 4),
	ELIMINAR_CLIENTE("Eliminar cliente", 5), ELIMINAR_VEHICULO("Eliminar Vehiculo", 6),
	ACTUALIZAR_VEHICULO("Actualizar Vehiculo", 7), ACTUALIZAR_CLIENTE("Actualizar Vliente", 8),
	VENDER_VEHICULO("Vender Vehiculo", 9), GENERAR_REPORTE("Generar Reporte", 10),
	ACTUALIZAR_INFO("Actualizar Info", 11), CAMBIAR_CONTRASENA("Cambiar Contraseña", 12),
	ESTAS_BLOQUEADO("Estas bloqueado", 13), ACERCA_DE("Acerca de", 14);

	private String text;
	private int orden;

	private OpcionMenu(String text, int orden) {
		this.text = text;
		this.orden = orden;
	}

	public String getText() {
		return text;
	}

	public int getOrden() {
		return orden;
	}

	public int compararPorPrioridad(OpcionMenu opt) {
		return orden - opt.orden;
	}

	public static OpcionMenu obtenerValorOpcion(String text) {
		OpcionMenu[] arr = OpcionMenu.values();
		for (OpcionMenu opcionesMenu : arr)
			if (opcionesMenu.getText().equals(text))
				return opcionesMenu;

		return null;
	}
}

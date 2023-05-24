package co.edu.uniquindio.concesionariouq.model;

import java.util.List;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoNoExisteException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;

public interface GestionableVehiculo {

	public void agregarVehiculo(String id, Vehiculo vehiculo)
			throws VehiculoYaExisteException, AtributosFaltantesException, NullException;

	public void eliminarVehiculo(String id)
			throws VehiculoNoExisteException, NullException;

	public Vehiculo buscarVehiculo(String id);

	public boolean validarVehiculo(String id);

	public List<Vehiculo> listarVehiculos();
}

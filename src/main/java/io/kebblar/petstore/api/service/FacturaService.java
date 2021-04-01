package io.kebblar.petstore.api.service;

import java.util.List;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.model.Criterio;
import io.kebblar.petstore.api.model.Factura;

public interface FacturaService {

	
	int insert(Factura factura) throws BusinessException;
	
	/**
	 * Regresa la totalidad de las facturas almacenadas en la base de datos.
	 * @return Lista de objetos de  tipo Factura
	 * @throws BusinessException Se dispara en caso de que no haya fondos en la cuenta
	 */
	List<Factura> getAll() throws BusinessException;

	/**
	 * Regresa los identificadores de las maascotas que cumplen con los criterios solicitados
	 * @param criterios Lista de criterios solicitados para la busqueda
	 * @return Lista de identificadores de las mascortas
	 */
	abstract List<Integer> getPetsByCriteria(List<Criterio> criterios);
}

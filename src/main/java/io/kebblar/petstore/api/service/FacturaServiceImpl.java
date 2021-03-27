package io.kebblar.petstore.api.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import io.kebblar.petstore.api.exceptions.BusinessException;
import io.kebblar.petstore.api.exceptions.ProductoInexistenteException;
import io.kebblar.petstore.api.mapper.FacturaMapper;
import io.kebblar.petstore.api.model.Factura;

@Service
public class FacturaServiceImpl implements FacturaService{

	private FacturaMapper facturaMapper;

	public FacturaServiceImpl(FacturaMapper facturaMapper) {
		this.facturaMapper = facturaMapper;
	}

	@Override
	public int insert(Factura factura) throws BusinessException {
		try {
			return this.facturaMapper.insert(factura);
		}catch (SQLException e) {
			throw new ProductoInexistenteException("Lo sentimos, ocurrio un error en base de datos."+ e.getErrorCode());
		}
	}

	@Override
	public List<Factura> getAll() throws BusinessException {
		try {
			return this.facturaMapper.getAll();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException("Ocurrio un error al consultar la informacion"
					+ e.getErrorCode());
		}
	}

}

package io.kebblar.petstore.api.exceptions;

public class ProductoInexistenteException  extends BusinessException{
 //Aqui se pueden agregar caracteristicas adicionales
	
	public ProductoInexistenteException(String msg) {
		super(msg);
	}
}

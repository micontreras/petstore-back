package io.kebblar.petstore.api.config;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.runtime.parser.node.GetExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import io.kebblar.petstore.api.exceptions.BusinessException;

/**
 * Controlador que manejara las excepciones lanzadas por los demas controladore
 * @author mariacg
 *
 */
@ControllerAdvice
public class CustomControllerAdvice {

	private Logger logger= LoggerFactory.getLogger(CustomControllerAdvice.class);
	
	/**
	 * Metodo que maneja las excepciones de {@link BusinessException}
	 * @param geEx la excepcion que manejara
	 * @return un diccionario con los valores a mostrarse en el JSON de salida
	 */
	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Map<String,Object>> errorHandler(BusinessException geEx){
		logger.error(getStackTraceExStr(geEx));
		return new ResponseEntity<>(crearMapaRetorno(geEx),HttpStatus.BAD_REQUEST);
	}


	/**
	 * Metodo auxiliar que obtiene la traza completa
	 * @param ex Excepcion lanzada
	 * @return Su representacion en String
	 */
	private String getStackTraceExStr(BusinessException excepcion) {
		StringBuilder errorGenerica= new StringBuilder();
		if(excepcion instanceof BusinessException) {
			BusinessException ge= (BusinessException) excepcion;
			errorGenerica.append("mensaje: ");
			errorGenerica.append(ge.getMessage());
			StringWriter errores = new StringWriter();
			ge.printStackTrace(new PrintWriter(errores));
			errorGenerica.append("\n");
		}
		return errorGenerica.toString();
	}

	/**
	 * Metodo auxiliar que crea el objeto a mostrartse cuando se lance la excepcion
	 * @param excepcion la excepcion a mapear
	 * @return el diccionario con la excepcion mapeada
	 */
	private Map<String,Object> crearMapaRetorno(Exception ex) {
		Map<String,Object> map = new HashMap<>();
		if(ex instanceof BusinessException) {
			BusinessException ad=(BusinessException)(ex);
			map.put("mensaje", ad.getMessage());
			map.put("tipo-error", ad.getMessage());
			map.put("cve-excepcion", ad.getMessage());
			map.put("http-error", ad.getMessage());
			map.put("desc-exception", ad.getMessage());
		}
		return map;
	}
}

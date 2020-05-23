package com.prueba.tecnica.archivoExcel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongDataException extends RuntimeException{

	private static final long serialVersionUID = -2859154957688573326L;

	public WrongDataException(String mensaje) {
		super(mensaje);
	}

}

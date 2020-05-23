package com.prueba.tecnica.archivoExcel.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
public class ResponseExceptionHandler extends ExceptionHandlerExceptionResolver {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Ocurrio un error general",
				ex.getMessage(), "" + ex.getClass(), -1);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ModelNotFoundException.class)
	public final ResponseEntity<Object> manejarModeloExcepciones(ModelNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Ocurrio un error general",
				ex.getMessage(), "" + ex.getClass(), -1);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({WrongDataException.class, NumberFormatException.class})
	public final ResponseEntity<Object> manejarErrorDatosExcepciones(WrongDataException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Ocurrio un error general",
				ex.getMessage(), "" + ex.getClass(), -1);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}

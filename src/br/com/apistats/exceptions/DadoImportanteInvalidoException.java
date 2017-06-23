/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.apistats.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

/**
 *
 * @author Elvis
 */
public class DadoImportanteInvalidoException extends Exception {

	private static final long serialVersionUID = 1776093874141420256L;

	public DadoImportanteInvalidoException(String message) {
        super(message);
    }

	public DadoImportanteInvalidoException(List<ObjectError> allErrors) {
		super(objectErrorToString(allErrors));
	}
	
	private static String objectErrorToString(List<ObjectError> allErrors) {
		StringBuilder message = new StringBuilder();
		for (ObjectError objectError : allErrors) {
			message.append("[");
			if (objectError instanceof FieldError) {
				FieldError fieldError = (FieldError) objectError;
				message.append(fieldError.getField());
				message.append(": ");
				message.append(fieldError.getDefaultMessage());
			} else {
				message.append(objectError.getDefaultMessage());
			}
			message.append("] ");
		}
		return message.toString();
	}
    
}

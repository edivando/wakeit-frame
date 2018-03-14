/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util.validation.exception;

import java.util.ArrayList;
import java.util.List;

import org.wakeit.frame.exception.BasicException;

/**
 * Class ValidationException
 *
 * @author edivandoalves
 * @date Feb 23, 2018
 * 
 * 
 */
public class ValidationException extends BasicException{

	private static final long serialVersionUID = 1L;
	
	private List<ValidatorException> exceptions = new ArrayList<ValidatorException>();
	
	
	public ValidationException(List<ValidatorException> excecoes) {
		super(null);
		this.exceptions = excecoes;
	}

	public String obterErros(){
		StringBuilder erros = new StringBuilder();
		for (ValidatorException ex : exceptions) {
			erros.append(ex.getMessage()).append("\n");
		}
		return erros.toString();
	}
	
	public List<ValidatorException> getExceptions(){
		return exceptions;
	}
}

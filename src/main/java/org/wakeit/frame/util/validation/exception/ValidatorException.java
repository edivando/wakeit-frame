/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util.validation.exception;

import org.wakeit.frame.exception.BasicRuntimeException;

/**
 * Class ValidatorException
 *
 * @author edivandoalves
 * @date Feb 23, 2018
 * 
 * 
 */
public class ValidatorException extends BasicRuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ValidatorException(String mensagem) {
		super(mensagem);
	}
}

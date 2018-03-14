/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.util;

import org.wakeit.frame.exception.ValidatorException;
import org.wakeit.frame.layer.entity.BasicEntity;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidatorUtils {
	
	
	public boolean isInteger(Integer value, String...message) throws ValidatorException{
		if(value == null || value.equals(0)){
			throw new ValidatorException(400, getMessage("Valor inteiro inválido", message));
		}
		return true;
	}
	
	public boolean isIntegerArray(Integer...value) throws ValidatorException{
		for (Integer v : value) {
			isInteger(v);
		}
		return true;
	}
	
	public boolean isString(String value, String...message) throws ValidatorException{
		if(value == null || value.equals("")){
			throw new ValidatorException(400, getMessage("Valor string inválido", message));
		}
		return true;
	}
	
	public boolean isStringArray(String...value) throws ValidatorException{
		for (String v : value) {
			isString(v);
		}
		return true;
	}
	
	public <E> boolean isNotNull(BasicEntity entity, String...message) throws ValidatorException{
		if(entity == null){
			throw new ValidatorException(400, getMessage("Objeto esta nulo", message));
		}
		return true;
	}
	

	private String getMessage(String defaultMessage, String...message){
		return message.length > 0 ? message[0]: defaultMessage;
	}
}

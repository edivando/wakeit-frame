/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.exception;

/**
 * 
 * @author Edivando Alves
 * @date  10/02/2016
 * 
 */
public class DAOException extends BasicException {
	private static final long serialVersionUID = 1L;
	
	public DAOException(String message){
		super(message);
	}
	
	public DAOException(String title, String message){
		super(title, message);
	}
	
	public DAOException(String message, Throwable e){
		super(e.getClass().getSimpleName(), message, e);
	}
}

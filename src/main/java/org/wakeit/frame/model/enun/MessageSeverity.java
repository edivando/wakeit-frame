/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.model.enun;

import lombok.Getter;

/**
 * Class Severity
 *
 * @author edivandoalves
 * @date Mar 6, 2018
 * 
 * 
 */
public enum MessageSeverity {
	INFO("info"), SUCCESS("success"), WARNING("warning"), ERROR("error");
	
	@Getter
	private final String method;
	
	private MessageSeverity(String method) {
		this.method = method;
	}
	
}

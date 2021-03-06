/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.annotation.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Class ScopeMap
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
@Qualifier
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScopeMap {
	
	ScopeMap.Scope value();
	
	public enum Scope{
		REQUEST, SESSION, APPLICATION;
	}

}

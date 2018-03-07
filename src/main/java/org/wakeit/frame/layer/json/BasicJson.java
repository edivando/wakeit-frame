/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.layer.json;

import java.io.Serializable;

import org.wakeit.frame.layer.entity.BasicEntity;

/**
 * Class BasicJson
 *
 * @author edivandoalves
 * @date Jul 9, 2017
 * 
 * 
 */
public interface BasicJson<T extends BasicEntity>  extends Serializable{

	T initJson(String json);
	
	String toJson();
		
}

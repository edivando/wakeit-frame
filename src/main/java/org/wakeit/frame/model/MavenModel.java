/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Class MavenProperties
 *
 * @author edivandoalves
 * @date Mar 13, 2018
 * 
 * 
 */
@Data
public class MavenModel implements Serializable{

	private static final long serialVersionUID = 4640154245552273151L;
	
	private String version;
	private String artifactId;

}

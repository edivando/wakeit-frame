/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
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

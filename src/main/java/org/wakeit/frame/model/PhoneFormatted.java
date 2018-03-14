/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.model;

import lombok.Getter;
import lombok.Setter;

public class PhoneFormatted {
	
	@Getter @Setter
	private String ddd;
	@Getter @Setter
	private String number;
	
	public PhoneFormatted(String ddd, String number) {
		super();
		this.ddd = ddd;
		this.number = number;
	}
	
	
}

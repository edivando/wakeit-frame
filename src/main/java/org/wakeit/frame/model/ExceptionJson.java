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

import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;

public class ExceptionJson implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Integer code;
	@Getter @Setter
	private String message;
	@Getter @Setter
	private String data;
	
	public ExceptionJson() {
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionJson(Integer code, String message, String data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	
	public String toJSON() {
		return new GsonBuilder().create().toJson(this);
	}

}

/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.helper;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;
import org.wakeit.frame.exception.BasicException;

import lombok.Getter;

/**
 * 
 * @author Edivando Alves
 * @date  26/08/2017
 * 
 */
public class Messages implements Serializable {
	
	private static final long serialVersionUID = 478623747197540209L;
	
	private static final String BUNDLE_MESSAGES = "br.com.rocketti.i18n.messages";
	
	@Inject
	private FacesContext context;
	
	public enum Severity{ 
		INFO("info"), SUCCESS("success"), WARNING("warning"), ERROR("error");
		
		@Getter
		private final String method;
		
		private Severity(String method) {
			this.method = method;
		}
	}


	public void show(Severity severity, String title, String key, String...param) {
		execute("toastr."+severity.method+"('"+formatMessage(key, param)+"', '"+formatMessage(title)+"');");
	}
	
	public void show(BasicException e) {
		execute("toastr."+e.getSeverity().getMethod()+"('"+formatMessage(e.getMessage())+"', '"+formatMessage(e.getTitle())+"');");
	}
	
	
	
	private void execute(String javascript){
		RequestContext.getCurrentInstance().execute(javascript);
	}
	
	private ResourceBundle getResourceMap(){
		return ResourceBundle.getBundle(BUNDLE_MESSAGES, context.getViewRoot().getLocale());  
	}
	
	private String getResourceValue( String key ){
		return getResourceMap().containsKey(key) ? getResourceMap().getString(key) : key;
	}
	
	private String formatMessage( String key, String...param ){
		if(key == null || key.isEmpty()){
			return "";
		}
		List<String> listParam = new ArrayList<String>();
		for (String string : param) {
			listParam.add( getResourceValue(string) );
		}
		return MessageFormat.format( getResourceValue( key ), listParam.toArray());   
	}
	
}

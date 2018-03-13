/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.factory;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.wakeit.frame.cdi.annotation.qualifier.ScopeMap;
import org.wakeit.frame.cdi.annotation.qualifier.ScopeMap.Scope;

/**
 * Class JsfFactory
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
public class JsfFactory {
	
	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public Flash getFlash() {
		return getExternalContext().getFlash();
	}
	
	@Produces
	@ScopeMap(Scope.REQUEST)
	public Map<String, Object> getRequestMap(){
		return getExternalContext().getRequestMap();
	}
	
	@Produces
	@ScopeMap(Scope.SESSION)
	public Map<String, Object> getSessionMap(){
		return getExternalContext().getSessionMap();
	}
	
	@Produces
	@ScopeMap(Scope.APPLICATION)
	public Map<String, Object> getApplicationMap(){
		return getExternalContext().getApplicationMap();
	}
	
	@Produces
	@RequestScoped
	public NavigationHandler getNavigationHandler() {
		return getFacesContext().getApplication().getNavigationHandler();
	}
	
	
	

	private ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
	

}

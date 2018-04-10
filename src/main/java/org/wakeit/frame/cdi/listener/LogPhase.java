/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.listener;

import javax.enterprise.event.Observes;
import javax.faces.component.UIViewRoot;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import org.wakeit.frame.cdi.annotation.qualifier.AfterPhase;
import org.wakeit.frame.cdi.annotation.qualifier.Maven;
import org.wakeit.frame.cdi.annotation.qualifier.Phase;
import org.wakeit.frame.cdi.annotation.qualifier.Phase.Phases;
import org.wakeit.frame.model.MavenModel;


/**
 * Class LogPhase
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
public class LogPhase {
	
	@Maven
	@Inject
	private MavenModel mavenModel;

	public void log(@Observes @AfterPhase @Phase(Phases.RESTORE_VIEW) PhaseEvent phaseEvent) {
		UIViewRoot viewRoot = phaseEvent.getFacesContext().getViewRoot();
		if(viewRoot != null) {
			System.out.println("["+mavenModel.getArtifactId().toUpperCase()+"]=> "+viewRoot.getViewId());
		}
	}
	
}

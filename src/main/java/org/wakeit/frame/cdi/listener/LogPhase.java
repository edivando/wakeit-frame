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
import javax.faces.event.PhaseEvent;

import org.wakeit.frame.cdi.annotation.qualifier.AfterPhase;
import org.wakeit.frame.cdi.annotation.qualifier.Phase;
import org.wakeit.frame.cdi.annotation.qualifier.Phase.Phases;


/**
 * Class LogPhase
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
public class LogPhase {

	public void log(@Observes @AfterPhase @Phase(Phases.RESTORE_VIEW) PhaseEvent phaseEvent) {
		System.out.println("FASE: "+phaseEvent.getPhaseId());
	}
	
}

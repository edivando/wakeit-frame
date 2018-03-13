/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.listener;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

import org.wakeit.frame.cdi.annotation.qualifier.Phase;;

/**
 * Class PhaseLIteral
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase{

	private Phases phases;

	public PhaseLiteral(PhaseId phaseId) {
		this.phases = Phase.Phases.valueOf(phaseId.getName());
	}
	
	@Override
	public Phases value() {
		return this.phases;
	}

}

/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.listener;

import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.wakeit.frame.cdi.annotation.qualifier.AfterPhase;

/**
 * Class BasicPhaseListener
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
public class BasicPhaseListener implements PhaseListener  {

	private static final long serialVersionUID = -3752799579526504713L;

	private BeanManager observer = CDI.current().getBeanManager();
	
	@SuppressWarnings("serial")
	@Override
	public void afterPhase(PhaseEvent event) {
		observer.fireEvent(event, new AnnotationLiteral<AfterPhase>() {}, new PhaseLiteral(event.getPhaseId()));
	}

	@SuppressWarnings("serial")
	@Override
	public void beforePhase(PhaseEvent event) {
		observer.fireEvent(event, new AnnotationLiteral<AfterPhase>() {}, new PhaseLiteral(event.getPhaseId()));
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}

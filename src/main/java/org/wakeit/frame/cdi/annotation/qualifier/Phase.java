/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.annotation.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.faces.event.PhaseId;
import javax.inject.Qualifier;

import lombok.Getter;

/**
 * Class ViewModel
 *
 * @author edivandoalves
 * @date Aug 13, 2017
 * 
 * 
 */
@Qualifier
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Phase {
	
	Phases value();
	
	public enum Phases {
		
		RESTORE_VIEW(PhaseId.RESTORE_VIEW),
		APPLY_REQUEST_VALUES(PhaseId.APPLY_REQUEST_VALUES),
		PROCESS_VALIDATIONS(PhaseId.PROCESS_VALIDATIONS),
		UPDATE_MODEL_VALUES(PhaseId.UPDATE_MODEL_VALUES),
		INVOKE_APPLICATION(PhaseId.INVOKE_APPLICATION),
		RENDER_RESPONSE(PhaseId.RENDER_RESPONSE);
		
		@Getter
		private final PhaseId phase;
		
		private Phases(PhaseId phase) {
			this.phase = phase;
		}
	}

}

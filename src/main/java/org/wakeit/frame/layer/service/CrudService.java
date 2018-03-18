/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.layer.service;

import java.io.Serializable;

import org.wakeit.frame.exception.ServiceException;
import org.wakeit.frame.layer.entity.BasicEntity;

/**
 * Class BasicService
 *
 * @author edivandoalves
 * @date Jul 23, 2017
 * 
 * 
 */
public interface CrudService<E extends BasicEntity> extends Serializable {
	
	public E save(E entity) throws ServiceException;
		
	public void delete(E entity) throws ServiceException;
	

}

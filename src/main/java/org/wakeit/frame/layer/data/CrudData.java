/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.layer.data;

import java.io.Serializable;

import org.wakeit.frame.exception.DataException;
import org.wakeit.frame.layer.entity.BasicEntity;

/**
 * Class BasicCrudData
 *
 * @author edivandoalves
 * @date Jul 23, 2017
 * 
 */
public interface CrudData<E extends BasicEntity> extends Serializable {
	
	public E save(E payment) throws DataException;
		
	public void delete(E payment) throws DataException;

}

/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.interceptor;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import org.wakeit.frame.cdi.annotation.Transactional;
import org.wakeit.frame.exception.DAOException;

/**
 * Class Transaction
 *
 * @author edivandoalves
 * @date Aug 9, 2017
 * 
 * 
 */
@Transactional
@Interceptor
public class TransactionInterceptor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	public EntityManager manager;
	
	@AroundInvoke
	public Object execute(InvocationContext context) throws DAOException {
		try {
			manager.getTransaction().begin();
			Object result = context.proceed();
			manager.getTransaction().commit();
			return result;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw new DAOException(e.getMessage(), e);
		}
	}

}

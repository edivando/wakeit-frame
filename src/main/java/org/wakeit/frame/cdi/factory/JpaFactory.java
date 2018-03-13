/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.cdi.factory;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class BasicJPA
 *
 * @author edivandoalves
 * @date Jul 23, 2017
 * 
 * 
 */
@ApplicationScoped
public class JpaFactory implements Serializable{
	private static final long serialVersionUID = -8732971614557917884L;

	private EntityManagerFactory emf;
	
	private static final String PERSISTENCE_UNIT = "localhost";
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager manager) {
		if(manager.isOpen()) {
			manager.close();			
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		if(emf.isOpen()) {
			emf.close();
		}
	}
	
	@PostConstruct
	public void init() {
		this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT); 
	}
	
	
}

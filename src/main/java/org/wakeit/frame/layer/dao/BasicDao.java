/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@wakeit.org ( http://www.wakeit.org )
 * 
 * @copyright  	Copyright 2018 Wake It Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.layer.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.wakeit.frame.exception.DAOException;
import org.wakeit.frame.layer.entity.BasicEntity;

import lombok.Getter;
import lombok.Setter;

public abstract class BasicDao<T extends BasicEntity, I> implements Serializable{
	
	private static final long serialVersionUID = -4038778073686421020L;
	
	@Inject
	@Getter @Setter
	private EntityManager manager;
	@Getter
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BasicDao() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public BasicDao(EntityManager manager) {
		this();
		this.manager = manager; 
	}
	
	public T save(T entity) throws DAOException {
		if(entity.isNew()) {
			persist(entity);
			return entity;
		}else {
			return merge(entity);
		}
	}
	
	public void persist(T entity) throws DAOException{
		try {
			manager.persist(entity);
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
	
	public T merge(T entity) throws DAOException{
		try {
			return manager.merge(entity); 
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
	
	public void delete(T entity) throws DAOException{
		try {
			manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
		}catch (Exception e) {
			throw new DAOException(e.getMessage(), e);
		}
	}
	
	public List<T> findAll(){
		return manager.createQuery("Select a From "+clazz.getSimpleName()+" a", clazz).getResultList();
	}
	
	public T findById(I id){
		return manager.find(clazz, id);
	}
	
	public Long countAll() {
		return manager.createQuery("SELECT COUNT(*) FROM "+clazz.getSimpleName(), Long.class).getSingleResult();
	}
	
	
	protected TypedQuery<T> createNamedQuery(String namedQuery) {
		return getManager().createNamedQuery(namedQuery, getClazz());
	}
	
	protected TypedQuery<T> createQuery(String query) {
		return getManager().createQuery(query, getClazz());
	}
	
	protected TypedQuery<?> createQuery(String query, Class<?> clazz) {
		return getManager().createQuery(query, clazz);
	}
	
	
	
}

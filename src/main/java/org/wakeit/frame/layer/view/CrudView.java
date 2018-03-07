/*
 * @version     1.0.0
 * @author      Edivando J. Alves
 * @contact     edivando@rocketti.com.br ( http://www.rocketti.com.br )
 * 
 * @copyright  	Copyright 2017 RocketTi Solutions, all rights reserved.
 * 
 */
package org.wakeit.frame.layer.view;

/**
 * 
 * @author Edivando Alves
 * @date  10/08/2017
 * 
 */
//public abstract class CrudView<E extends BasicEntity> extends BasicView{
//
//	private static final long serialVersionUID = 1L;
//
//	@Setter 
//	protected E entity;
//	@Getter
//	protected List<E> entitys;
//
//	@Getter @Setter
//	private boolean form = false;
//	
//	@Getter
//	private Page page;
//	@Getter
//	private String gridTitle;
//	private String newTitle;
//	private String editTitle;
//	
//	public CrudView(Page page, String gridTitle, String newTitle, String editTitle) {
//		this.page = page;
//		this.gridTitle = gridTitle;
//		this.newTitle = newTitle;
//		this.editTitle = editTitle;
//	}
//	
//	@PostConstruct
//	public void init(){
//		entitys = loadEntitys();
//	}
//	
//	public void grid(){
//		entity = null;
//		form = false;
//		entitys = loadEntitys();
//	}
//	
//	public String getTitle() {
//		return form ? ((entity == null || entity.isNew()) ? newTitle : editTitle) : gridTitle;
//	}
//	
//	public abstract List<E> loadEntitys();
//	
//	public abstract E getEntity();
//
//	public void form(){
//		form = true;
//	}
//	
//	public void edit(E entity) {
//		setEntity(entity);
//		form();
//	}
//	
//	
//}

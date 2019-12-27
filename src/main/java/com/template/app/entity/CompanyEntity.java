package com.template.app.entity;

public class CompanyEntity implements IEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public CompanyEntity() {
		
	}
	
	public CompanyEntity(Long id) {
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

}

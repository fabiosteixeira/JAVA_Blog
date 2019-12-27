package com.javablog.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="AUTHOR")
@SequenceGenerator(name = "AUTHOR_ID_GENERATOR", sequenceName = "SE_AUTHOR", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="AuthorEntity.retrieveAll", query="Select distinct a from AuthorEntity a order by a.name"),
}) 

public class AuthorEntity implements IEntity<Long>{

	private static final long serialVersionUID = 7739781157774478940L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_ID_GENERATOR")
	private Long id;
	
	@NotNull 
	@Size(min=3, max = 40)
	@Column
	private String name;
	
	@Override
	public Long getId() {
		return id;
	}
		
	public String getName() {
		return name;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}
	
	public void setName(String name) {
		this.name = name;
	}

}

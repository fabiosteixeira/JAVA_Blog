package com.javablog.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="POST")
@SequenceGenerator(name = "POST_ID_GENERATOR", sequenceName = "SE_POST", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="PostEntity.retrieveAll", query="Select distinct p from PostEntity p left outer join p.author a left outer join p.comments c order by p.id")
}) 

public class PostEntity implements IEntity<Long>{

	private static final long serialVersionUID = 5164883978171987166L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_ID_GENERATOR")
	private Long id;
	
	@NotNull
	@ManyToOne (targetEntity = AuthorEntity.class, fetch = FetchType.LAZY)
	private AuthorEntity author;
	
	@NotNull 
	@Size(min=3, max = 200)
	@Column
	private String content;
	
	@OneToMany (targetEntity = CommentEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="post")
	private List<CommentEntity> comments;	
	
	@Override
	public Long getId() {
		return id;
	}
	
	public AuthorEntity getAuthor() {
		return author;
	}
	
	public String getContent() {
		return content;
	}
	
	public List<CommentEntity> getComments() {
		return comments;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}	

}
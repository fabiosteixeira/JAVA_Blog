package com.javablog.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="COMMENT")
@SequenceGenerator(name = "COMMENT_ID_GENERATOR", sequenceName = "SE_COMMENT", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class CommentEntity implements IEntity<Long>{

	private static final long serialVersionUID = -6162450739875761416L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_ID_GENERATOR")
	private Long id;
	
	@NotNull
	@ManyToOne (targetEntity = PostEntity.class)  
    @JoinColumn(name="post_id", referencedColumnName="id")
    @XmlTransient
	private PostEntity post;
	
	@NotNull 
	@Size(min=3, max = 100)
	@Column
	private String content;
	
	private Date data;
	
	@Override
	public Long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public PostEntity getPost() {
		return post;
	}
	
	public Date getData() {
		return data;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;		
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
}

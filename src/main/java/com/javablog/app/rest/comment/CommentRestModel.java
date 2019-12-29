package com.javablog.app.rest.comment;

import javax.validation.constraints.Size;

public class CommentRestModel {

	private Long id;
	
	private Long post_id;
	
	@Size(min=3, max = 100)
	private String content;
	
	public Long getId() {
		return id;
	}
	
	public Long getPost_id() {
		return post_id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}		
	
}

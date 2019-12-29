package com.javablog.app.rest.post;

public class PostRestModel {

	private Long id;
	private Long author_id;
	private String content;
	
	public Long getId() {
		return id;
	}
	
	public Long getAuthor_id() {
		return author_id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}	

	public void setContent(String content) {
		this.content = content;
	}
	
}

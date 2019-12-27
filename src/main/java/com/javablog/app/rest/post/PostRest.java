package com.javablog.app.rest.post;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javablog.app.entity.PostEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.model.service.IEntityService;
import com.javablog.app.model.service.post.IPostService;
import com.javablog.app.rest.AbstractRest;
import com.javablog.app.rest.author.AuthorRest;

@Path("/post")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class PostRest extends AbstractRest<Long, PostEntity>{
	
private final static Logger LOGGER = Logger.getLogger(AuthorRest.class.getName());
	
	@Inject
	private IPostService postService;
	
	@Override
	protected IEntityService<Long, PostEntity> getEntityService() {
		return postService;
	}

	@GET
	@Path("/all")
	public List<PostEntity> getAllPosts() throws AppException{
		LOGGER.info("PostRest.getAllPosts");
		List<PostEntity> list = postService.retrieveAll();
		handleNoContent(list);
		LOGGER.info("PostRest.getAllPosts: "+list);
		return list;
	}
	
}

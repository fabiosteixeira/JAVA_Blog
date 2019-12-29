package com.javablog.app.rest.post;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javablog.app.entity.AuthorEntity;
import com.javablog.app.entity.PostEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.model.service.IEntityService;
import com.javablog.app.model.service.post.IPostService;
import com.javablog.app.model.service.repository.author.AuthorRepository;
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
	
	@Inject
	private AuthorRepository authorRepository;	

	@GET
	@Path("/all")
	public List<PostEntity> getAllPosts() throws AppException{
		LOGGER.info("PostRest.getAllPosts");
		List<PostEntity> list = postService.retrieveAll();
		handleNoContent(list);
		LOGGER.info("PostRest.getAllPosts: "+list);
		return list;
	}
	
	@GET
	@Path("/{id}")
	public PostEntity get( @PathParam("id") Long entityId ) throws AppException {
		LOGGER.info("PostRest.get{id}");
		PostEntity p =  postService.get(entityId);
		LOGGER.info("PostRest.get{id}: " + p);
		return p;
	}
	
	@POST
	@Path("/create")
	public PostEntity create(PostRestModel entity) throws AppException {
		LOGGER.info("PostRest.create");
		try {
			PostEntity e = new PostEntity();
			AuthorEntity a = authorRepository.get(entity.getAuthor_id());
			
			if (a == null) {
				throw new AppException("O autor não pode ser nulo para a criação de um novo post.");
			}
			
			e.setAuthor(a);
			e.setContent(entity.getContent());						
			PostEntity out = update(e);			
			LOGGER.info("PostServiceImpl.create: " + out);
			return out;	
		}catch(Exception ex){
	    	LOGGER.severe("PostServiceImpl.create: Exception " + ex.getMessage());
	    	return null;
	    }	
	}
	
	@PUT
	@Path("/{id}")
	public PostEntity update(@PathParam("id") Long entityId, PostRestModel entity) throws AppException {
		LOGGER.info("PostRest.update");
		try {
			PostEntity e = postService.get(entityId);			
			if (e == null)
				throw new AppException("Post não localizado para atualização.");
			
			AuthorEntity a = authorRepository.get(entity.getAuthor_id());
			if (a != null)			
				e.setAuthor(a);
			
			if (entity.getContent()!=null)
				e.setContent(entity.getContent());						
			PostEntity out = update(e);			
			LOGGER.info("PostServiceImpl.update: " + out);
			return out;	
		}catch(Exception ex){
	    	LOGGER.severe("PostServiceImpl.update: Exception " + ex.getMessage());
	    	return null;
	    }
	}
	
}

package com.javablog.app.rest.author;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javablog.app.entity.AuthorEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.model.service.IEntityService;
import com.javablog.app.model.service.author.IAuthorService;
import com.javablog.app.rest.AbstractRest;


@Path("/author")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AuthorRest extends AbstractRest<Long, AuthorEntity>{
		
	private final static Logger LOGGER = Logger.getLogger(AuthorRest.class.getName());
	
	@Inject
	private IAuthorService authorService;
	
	@Override
	protected IEntityService<Long, AuthorEntity> getEntityService() {
		return authorService;
	}

	@GET
	@Path("/all")
	public List<AuthorEntity> getAllAuthors() throws AppException{
		LOGGER.info("AuthorRest.getAllAuthors");
		List<AuthorEntity> list = authorService.retrieveAll();
		handleNoContent(list);
		LOGGER.info("AuthorRest.getAllAuthors: "+list);
		return list;
	}
	
}

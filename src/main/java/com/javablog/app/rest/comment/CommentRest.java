package com.javablog.app.rest.comment;

import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javablog.app.entity.CommentEntity;
import com.javablog.app.entity.PostEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.model.service.IEntityService;
import com.javablog.app.model.service.comment.ICommentService;
import com.javablog.app.model.service.repository.post.PostRepository;
import com.javablog.app.rest.AbstractRest;

@Path("/comment")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CommentRest extends AbstractRest<Long, CommentEntity>{

	private final static Logger LOGGER = Logger.getLogger(CommentRest.class.getName());
	
	@Inject
	private ICommentService commentService;

	@Override
	protected IEntityService<Long, CommentEntity> getEntityService() {
		return commentService;
	}
	
	@Inject
	private PostRepository postRepository;
	
	@POST
	@Path("/create")
	public CommentEntity create(CommentRestModel entity) throws AppException {
		LOGGER.info("CommentRest.create");
		try {
			CommentEntity e = new CommentEntity();
			PostEntity p = postRepository.get(entity.getPost_id());
			
			if (p == null) {
				throw new AppException("O post não pode ser nulo para a criação de um novo comentário.");
			}
			
			e.setPost(p);
			e.setContent(entity.getContent());		
			e.setData(new Date(System.currentTimeMillis()));
			CommentEntity out = update(e);	
			LOGGER.info("CommentRest.create: " + out);
			return out;	
		}catch(Exception ex){
	    	LOGGER.severe("CommentRest.create: Exception " + ex.getMessage());
	    	return null;
	    }
	}
	
}

package com.javablog.app.model.service.post;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.javablog.app.entity.PostEntity;
import com.javablog.app.model.service.AbstractServiceEntity;
import com.javablog.app.model.service.repository.IEntityRepository;
import com.javablog.app.model.service.repository.post.PostRepository;

public class PostServiceImpl extends AbstractServiceEntity<Long, PostEntity> implements IPostService {

	private final static Logger LOGGER = Logger.getLogger(PostServiceImpl.class.getName());
	
	@Inject
	private PostRepository postRepository;

	@Override
	protected IEntityRepository<Long, PostEntity> getEntityRepository() {
		return postRepository;
	}
	
	@Override
	public List<PostEntity> retrieveAll() {	
		LOGGER.info("PostEntity.retrieveAll");
		List<PostEntity> list = postRepository.retrieveAll();
		
		// Mounting DTO in the same object
		List<PostEntity> newList = new ArrayList<PostEntity>();
		for(PostEntity a : list) {
			PostEntity newA = getPostDTO(a);	
			newList.add(newA);
		}
		LOGGER.info("AuthorServiceImpl.retrieveAll: "+newList);
		return newList;
	}
	
	protected PostEntity getPostDTO(PostEntity a) {
		LOGGER.info("PostServiceImpl.getPostDTO");
		PostEntity newA = new PostEntity();
		newA.setId(a.getId());
		newA.setAuthor(a.getAuthor());
		newA.setContent(a.getContent());
		newA.setComments(a.getComments());
		return newA;
	}
	
	@Override
	public PostEntity get(Long id) {
		LOGGER.info("PostServiceImpl.get(id)");
		PostEntity p = postRepository.get(id);
		if (p!=null) { 
			PostEntity newP = getPostDTO(p);
			LOGGER.info("PostServiceImpl.get(id): "+newP);
			return newP;
		} else {
			LOGGER.info("PostServiceImpl.get(id): null");
			return null;
		}		
	}	
	
}

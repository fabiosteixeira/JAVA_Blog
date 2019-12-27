package com.javablog.app.model.service.repository.post;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import com.javablog.app.entity.PostEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.messages.AppBeanMessages;
import com.javablog.app.model.service.repository.AbstractRepository;

public class PostRepository extends AbstractRepository<Long, PostEntity> {
	
	private final static Logger LOGGER = Logger.getLogger(PostRepository.class.getName());

	@Override
	public Class<PostEntity> getEntityType() {
		return PostEntity.class;
	}
	
	public List<PostEntity> retrieveAll() {
		try {
			LOGGER.info("PostEntity.retrieveAll");
			String namedQuery = "PostEntity.retrieveAll";

			Query query = getEntityManager().createNamedQuery(namedQuery);

			@SuppressWarnings("unchecked")
			List<PostEntity> list = (List<PostEntity>)query.getResultList( );
			LOGGER.info("PostEntity.retrieveAll: return "+list);
			return list;

		} catch (AppException e) {
			LOGGER.severe("PostEntity.retrieveAll AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("PostEntity.retrieveAll Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}
}
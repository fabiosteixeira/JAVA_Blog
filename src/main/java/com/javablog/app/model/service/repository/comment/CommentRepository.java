package com.javablog.app.model.service.repository.comment;

import javax.annotation.Resource;
import javax.transaction.UserTransaction;

import com.javablog.app.entity.CommentEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.messages.AppBeanMessages;
import com.javablog.app.model.service.repository.AbstractRepository;

public class CommentRepository extends AbstractRepository<Long, CommentEntity> {
	
	@Resource
    private UserTransaction userTransaction;
	
	@Override
	public Class<CommentEntity> getEntityType() {
		return CommentEntity.class;
	}

	public CommentEntity update(CommentEntity commentEntity) {
		try {
			userTransaction.begin();
			if (commentEntity.getId()==null)
				getEntityManager().persist(commentEntity);
			else
				getEntityManager().merge(commentEntity);
			userTransaction.commit();
			return commentEntity;
		} catch (AppException e) {
			throw e;
		} catch (Exception e) {
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}		
	}
	
}

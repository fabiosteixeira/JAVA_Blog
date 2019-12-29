package com.javablog.app.model.service.comment;

import java.util.logging.Logger;

import javax.inject.Inject;

import com.javablog.app.entity.CommentEntity;
import com.javablog.app.model.service.AbstractServiceEntity;
import com.javablog.app.model.service.repository.IEntityRepository;
import com.javablog.app.model.service.repository.comment.CommentRepository;

public class CommentServiceImpl extends AbstractServiceEntity<Long, CommentEntity> implements ICommentService {

	private final static Logger LOGGER = Logger.getLogger(CommentServiceImpl.class.getName());
	
	@Inject
	private CommentRepository commentRepository;

	@Override
	protected IEntityRepository<Long, CommentEntity> getEntityRepository() {
		return commentRepository;
	}

	
}

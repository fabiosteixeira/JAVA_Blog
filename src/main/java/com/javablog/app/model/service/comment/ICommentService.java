package com.javablog.app.model.service.comment;

import com.javablog.app.entity.CommentEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.model.service.IEntityService;

public interface ICommentService extends IEntityService<Long, CommentEntity>{
	
	CommentEntity create(CommentEntity entity) throws AppException;
	
	CommentEntity get(Long id);

}

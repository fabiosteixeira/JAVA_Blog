package com.javablog.app.model.service.post;

import java.util.List;

import com.javablog.app.entity.PostEntity;
import com.javablog.app.model.service.IEntityService;

public interface IPostService extends IEntityService<Long, PostEntity>{
	
	List<PostEntity> retrieveAll();

}

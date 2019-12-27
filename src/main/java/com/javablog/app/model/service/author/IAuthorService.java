package com.javablog.app.model.service.author;

import java.util.List;

import javax.ejb.Local;

import com.javablog.app.entity.AuthorEntity;
import com.javablog.app.model.service.IEntityService;

@Local
public interface IAuthorService  extends IEntityService<Long, AuthorEntity>{

	List<AuthorEntity> retrieveAll();

//	AuthorEntity get(Long id, String relationships);
//
//	List<ProductEntity> getChildProducts(Long id);
//   
//	List<ImageEntity>  getImages(Long id);

}

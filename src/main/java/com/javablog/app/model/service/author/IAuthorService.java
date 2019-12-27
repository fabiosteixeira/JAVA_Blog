package com.javablog.app.model.service.author;

import javax.ejb.Local;

import com.javablog.app.entity.AuthorEntity;
import com.javablog.app.model.service.IEntityService;

@Local
public interface IAuthorService  extends IEntityService<Long, AuthorEntity>{

//	List<ProductEntity> retrieveAll(String relationships);
//
//	AuthorEntity get(Long id, String relationships);
//
//	List<ProductEntity> getChildProducts(Long id);
//   
//	List<ImageEntity>  getImages(Long id);

}

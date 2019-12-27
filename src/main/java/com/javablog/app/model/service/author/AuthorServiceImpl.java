package com.javablog.app.model.service.author;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.javablog.app.entity.AuthorEntity;
import com.javablog.app.model.service.AbstractServiceEntity;
import com.javablog.app.model.service.repository.IEntityRepository;
import com.javablog.app.model.service.repository.author.AuthorRepository;

@Stateless
public class AuthorServiceImpl extends AbstractServiceEntity<Long, AuthorEntity> implements IAuthorService {

	private final static Logger LOGGER = Logger.getLogger(AuthorServiceImpl.class.getName());	
	
	@Inject
	private AuthorRepository authorRepository;

	@Override
	protected IEntityRepository<Long, AuthorEntity> getEntityRepository() {
		return authorRepository;
	}

	@Override
	public List<AuthorEntity> retrieveAll() {	
		LOGGER.info("AuthorEntity.retrieveAll");
		List<AuthorEntity> list = authorRepository.retrieveAll();
		
		// Mounting DTO in the same object
		List<AuthorEntity> newAuthorList = new ArrayList<AuthorEntity>();
		for(AuthorEntity a : list) {
			AuthorEntity newA = getAuthorDTO(a);	
			newAuthorList.add(newA);
		}
		LOGGER.info("AuthorServiceImpl.retrieveAll: "+newAuthorList);
		return newAuthorList;
	}
//
//	@Override
//	public ProductEntity get(Long id) {
//		LOGGER.info("ProductServiceImpl.get");
//		return get(id, "");
//	}
//	
//	@Override
//	public ProductEntity get(Long id, String relationships) {
//		LOGGER.info("ProductServiceImpl.get(relationships)");
//		ProductEntity p = productRepository.get(id, relationships);
//		if (p!=null) { 
//			ProductEntity newP = getProductDTO(relationships, p);
//			LOGGER.info("ProductServiceImpl.get(relationships): "+newP);
//			return newP;
//		} else {
//			LOGGER.info("ProductServiceImpl.get(relationships): null");
//			return null;
//		}
//		
//	}
	
	
	protected AuthorEntity getAuthorDTO(AuthorEntity a) {
		LOGGER.info("AuthorServiceImpl.getAuthorDTO");
		AuthorEntity newA = new AuthorEntity();
		newA.setId(a.getId());
		newA.setName(a.getName());				
		return newA;
	}

//	@Override
//	public List<ProductEntity> getChildProducts(Long id) {
//		LOGGER.info("ProductServiceImpl.getChildProducts");
//		List<ProductEntity> childProducts = productRepository.getChildProducts(id);
//		// Mounting DTO in the same object
//		List<ProductEntity> newProductList = new ArrayList<ProductEntity>();
//		for(ProductEntity p : childProducts) {
//			ProductEntity newP = getProductDTO("", p);	
//			newProductList.add(newP);
//		}
//		LOGGER.info("ProductServiceImpl.getChildProducts: "+newProductList);
//		return newProductList;
//	}
//
//	@Override
//	public List<ImageEntity> getImages(Long id) {
//		LOGGER.info("ProductServiceImpl.getImages");
//		List<ImageEntity> listImages = productRepository.getImages(id);
//		LOGGER.info("ProductServiceImpl.getImages: "+listImages);
//		return listImages;
//	}
	
}

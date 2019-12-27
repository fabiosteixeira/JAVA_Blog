package com.javablog.app.model.service.repository.author;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import com.javablog.app.entity.AuthorEntity;
import com.javablog.app.exception.AppException;
import com.javablog.app.messages.AppBeanMessages;
import com.javablog.app.model.service.repository.AbstractRepository;

public class AuthorRepository extends AbstractRepository<Long, AuthorEntity> {

	private final static Logger LOGGER = Logger.getLogger(AuthorRepository.class.getName());

	@Override
	public Class<AuthorEntity> getEntityType() {
		return AuthorEntity.class;
	}

	public List<AuthorEntity> retrieveAll() {
		try {
			LOGGER.info("AuthorEntity.retrieveAll");
			String namedQuery = "AuthorEntity.retrieveAll";

			Query query = getEntityManager().createNamedQuery(namedQuery);

			@SuppressWarnings("unchecked")
			List<AuthorEntity> list = (List<AuthorEntity>)query.getResultList( );
			LOGGER.info("AuthorEntity.retrieveAll: return "+list);
			return list;

		} catch (AppException e) {
			LOGGER.severe("AuthorEntity.retrieveAll AppException: "+e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.severe("AuthorEntity.retrieveAll Exception: "+e.getMessage());
			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
		}
	}

//	public ProductEntity get(Long id, String relationships) {
//		try {
//			LOGGER.info("ProductRepository.get: id "+id+" relationships:"+relationships);
//			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//			CriteriaQuery q = cb.createQuery(ProductEntity.class);
//			Root o = q.from(ProductEntity.class);
//
//			if (relationships!=null && relationships.equals("i")) {
//				o.fetch("images", JoinType.LEFT);
//			} else if (relationships!=null && relationships.equals("p")) {
//				o.fetch("parentProduct", JoinType.LEFT);
//			} else if (relationships!=null && relationships.equals("ip")) {
//				o.fetch("images", JoinType.LEFT);
//				o.fetch("parentProduct", JoinType.LEFT);
//			}	
//
//			q.select(o);
//			q.where(cb.equal(o.get("id"), id));
//
//			ProductEntity p = (ProductEntity)getEntityManager().createQuery(q).getSingleResult();	
//			LOGGER.info("ProductRepository.get: return "+p);
//			return p;
//
//		} catch (AppException e) {
//			LOGGER.severe("ProductRepository.get AppException: "+e.getMessage());
//			throw e;
//		} catch (Exception e) {
//			LOGGER.severe("ProductRepository.get Exception: "+e.getMessage());
//			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
//		}
//	}
//
//
//	public List<ProductEntity> getChildProducts(Long id) {
//		try{
//			LOGGER.info("ProductRepository.getChildProducts: "+id);
//			Query query = getEntityManager().createNamedQuery("ProductEntity.getChildProducts");
//			query.setParameter("id", id);
//			List<ProductEntity> childProducts = (List<ProductEntity>)query.getResultList( );
//			LOGGER.info("ProductRepository.getChildProducts: return "+childProducts);
//			return childProducts;
//		} catch (AppException e) {
//			LOGGER.severe("ProductRepository.getChildProducts AppException: "+e.getMessage());
//			throw e;
//		} catch (Exception e) {
//			LOGGER.severe("ProductRepository.getChildProducts Exception: "+e.getMessage());
//			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
//		}
//	}
//
//
//	public List<ImageEntity> getImages(Long id) {
//		try{
//			LOGGER.info("ProductRepository.getImages: "+id);
//			Query query = getEntityManager().createNamedQuery("ProductEntity.getImages");
//			query.setParameter("id", id);
//			List<ImageEntity> list = (List<ImageEntity>)query.getResultList( );
//			LOGGER.info("ProductRepository.getImages: return "+list);
//			return list;
//		} catch (AppException e) {
//			LOGGER.severe("ProductRepository.getImages AppException: "+e.getMessage());
//			throw e;
//		} catch (Exception e) {
//			LOGGER.severe("ProductRepository.getImages Exception: "+e.getMessage());
//			throw AppBeanMessages.PERSISTENCE_ERROR.create(e, e.getMessage());
//		}
//	}
}


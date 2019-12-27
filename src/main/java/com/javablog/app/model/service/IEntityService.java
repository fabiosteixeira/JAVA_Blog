package com.javablog.app.model.service;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import com.javablog.app.entity.IEntity;
import com.javablog.app.exception.AppException;

/**
 * Generic service interface to define CRUD operations
 * @param <PK> Primary Key
 * @param <E> Entity
 */
public interface IEntityService<PK extends Serializable, E extends IEntity<PK>> {
	
   List<E> retrieve() throws AppException;

   E get(PK id);

   E create(@Valid E entity) throws AppException;

   E update(@Valid E entity) throws AppException;

   void delete(E entity) throws AppException;
   
}

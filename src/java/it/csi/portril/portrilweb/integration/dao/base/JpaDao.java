/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class JpaDao<E, PK> implements Dao<E, PK> {

	private Logger log = Logger.getLogger(this.getClass());

	protected Class<E> entityClass;
	private String listAllQueryName;

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Crea una nuova istanza della classe.
	 */
	protected JpaDao() {
		this.entityClass = getEntityClass(getClass());
		listAllQueryName = entityClass.getSimpleName() + ".findAll";
	}

	@SuppressWarnings("unchecked")
	private Class<E> getEntityClass(Class<?> c) {
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			return (Class<E>) ((ParameterizedType) type)
					.getActualTypeArguments()[0];
		} else {
			return getEntityClass((Class<?>) type);
		}
	}

	@Override
	public void save(E entity) {
		String METHOD_NAME = "[save] - ";
		try {
			log.debug(METHOD_NAME + "inizio");
			entityManager.persist(entity);
			log.debug(METHOD_NAME + "save successful");
		} catch (RuntimeException re) {
			log.error(METHOD_NAME + "save failed", re);
			throw re;
		} finally {
			log.debug(METHOD_NAME + "fine");
		}
	}

	protected Query createNamedQuery(String queryName) {
		try {
			return entityManager.createNamedQuery(queryName);
		} catch (IllegalArgumentException e) {
			throw new UnsupportedOperationException("problema creazione NamedQuery " + queryName, e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll(int... rowStartIdxAndCount) {
		 String METHOD_NAME = "[findAll] - ";
		try {
			log.debug(METHOD_NAME + "inizio");
			Query query = createNamedQuery(listAllQueryName);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error(METHOD_NAME + "findAll failed", re);
			throw re;
		} finally {
			log.debug(METHOD_NAME + "fine");
		}
	}

	@Override
	public E findById(PK id) {
		 String METHOD_NAME = "[findById] - ";
		try {
			log.debug(METHOD_NAME + "inizio");
			log.debug(METHOD_NAME + "id " +id);
			return entityManager.find(entityClass, id);
		} catch (RuntimeException re) {
			log.error(METHOD_NAME + "findById failed", re);
			throw re;
		} finally {
			log.debug(METHOD_NAME + "fine");
		}
	}

	@Override
	public void delete(E entity) {
		 String METHOD_NAME = "[delete] - ";
		try {
			log.debug(METHOD_NAME + "inizio");
			entityManager.remove(entity);
			log.debug(METHOD_NAME + "delete successful");
		} catch (RuntimeException re) {
			log.error(METHOD_NAME + "delete failed", re);
			throw re;
		} finally {
			log.debug(METHOD_NAME + "fine");
		}
	}

	@Override
	public E update(E entity) {
		 String METHOD_NAME = "[update] - ";
		try {
			log.debug(METHOD_NAME + "inizio");
			E result = entityManager.merge(entity);
			log.debug(METHOD_NAME + "update successful");
			return result;
		} catch (RuntimeException re) {
			log.error(METHOD_NAME + "update failed", re);
			throw re;
		} finally {
			log.debug(METHOD_NAME + "fine");
		}
	}

	protected <T> Page<T> getPagedList(String jpql,Map<String, Object> parameters, Pageable pageable) {

		String jpqlCount = getCountQuery(jpql);
		Query qn = createQuery(jpqlCount, parameters);

		long count = ((Number) qn.getSingleResult()).longValue();

		List<T> resultList = new ArrayList<T>();
		if (count > 0) {
			Query query = createQuery(jpql, parameters);
			query.setFirstResult(pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
			resultList = query.getResultList();
		}

		Page<T> pagedList = new PageImpl<T>(resultList, pageable, count);

		return pagedList;
	}
	
	protected <T> Page<T> getPagedList(String jpql, Map<String, Object> parameters, Pageable pageable, Class<T> clazz) {

		String jpqlCount = getCountQuery(jpql);
		Query qn = createQuery(jpqlCount, parameters);

		long count = ((Number) qn.getSingleResult()).longValue();

		List<T> resultList = new ArrayList<T>();
		if (count > 0) {
			TypedQuery<T> query = createQuery(jpql, parameters, clazz);
			query.setFirstResult(pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
			resultList = query.getResultList();
		}

		Page<T> pagedList = new PageImpl<T>(resultList, pageable, count);

		return pagedList;
	}

	protected <T> Page<T> getNativePagedList(String jpql,Map<String, Object> parameters, Pageable pageable) {

		String jpqlCount = getCountQuery(jpql);
		Query qn = createQuery(jpqlCount, parameters);

		long count = ((Number) qn.getSingleResult()).longValue();

		List<T> resultList = new ArrayList<T>();
		if (count > 0) {
			Query query = createNativeQuery(jpql,parameters);
			query.setFirstResult(pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
			resultList = query.getResultList();
		}

		Page<T> pagedList = new PageImpl<T>(resultList, pageable, count);

		return pagedList;
	}

	
	private String getCountQuery(String jpql) {
		String jpqlCount = "";

		int fromIndex = jpql.toUpperCase().indexOf("FROM");
		jpqlCount = jpql.substring(fromIndex);

		int toIndex = jpql.toUpperCase().lastIndexOf("ORDER");
		if (toIndex != -1) {
			jpqlCount = jpql.substring(0, toIndex);
		}

		jpqlCount = String.format("SELECT COUNT(*) %s", jpqlCount);
		log.debug("jpqlCount " + jpqlCount);
		return jpqlCount;
	}

	/*
	 * protected <T> ListaPaginata<T> getPagedList(String jpql, Map<String,
	 * Object> parameters, ParametriPaginazione pageParams) { Query qn =
	 * createQuery(String.format("SELECT COUNT(*) FROM (%s)", jpql),
	 * parameters); Number count = (Number) qn.getSingleResult();
	 * 
	 * Query query = createQuery(jpql, parameters);
	 * 
	 * query.setFirstResult(pageParams.getPrimoElemento());
	 * query.setMaxResults(pageParams.getElementiPerPagina());
	 * 
	 * @SuppressWarnings("unchecked") ListaPaginataImpl<T> pagedList = new
	 * ListaPaginataImpl<T>(query.getResultList());
	 * 
	 * pagedList.setTotaleElementi(count.intValue());
	 * 
	 * return pagedList; }
	 */

	protected Query createQuery(String jpql, Map<String, Object> parameters) {
		Query query = entityManager.createQuery(jpql);

		if (parameters != null)
			setQueryParameters(query, parameters);

		return query;
	}
	
	protected <T> TypedQuery<T> createQuery(String jpql, Map<String, Object> parameters, Class<T> clazz) {
		TypedQuery<T> query = entityManager.createQuery(jpql, clazz);

		if (parameters != null)
			setQueryParameters(query, parameters);

		return query;
	}

	protected <T> Query createNativeQuery(String sql, Class<T> resultClass,
			Map<String, Object> parameters) {
		Query query = entityManager.createNativeQuery(sql, resultClass);

		if (parameters != null)
			setQueryParameters(query, parameters);

		return query;
	}
	
	protected <T> Query createNativeQuery(String sql, Map<String, Object> parameters) {
		Query query = entityManager.createNativeQuery(sql);

		if (parameters != null)
			setQueryParameters(query, parameters);

		return query;
	}

	//
	//
	// protected <T> TypedQuery<T> createNativeQuery(String jpql, Class<T>
	// resultClass, Map<String, Object> parameters)
	// {
	// TypedQuery<T> query = entityManager.createQuery(jpql, resultClass);
	//
	// if (parameters != null)
	// for (Map.Entry<String, Object> param : parameters.entrySet())
	// query.setParameter(param.getKey(), param.getValue());
	//
	// return query;
	// }

	private void setQueryParameters(Query query, Map<String, Object> parameters) {
		for (Map.Entry<String, Object> param : parameters.entrySet())
			query.setParameter(param.getKey(), param.getValue());
	}

	protected int executeQuery(String jpql, Map<String, Object> parameters) {
		return createQuery(jpql, parameters).executeUpdate();
	}

}

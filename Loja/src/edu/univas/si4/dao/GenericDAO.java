package edu.univas.si4.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDAO<Entity, PK> {
	
	protected EntityManager entityManager;
	private Class<Entity> persistentClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("loja");
			
		entityManager = factory.createEntityManager();
		
		persistentClass = 
				(Class<Entity>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	public void update(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	public void delete(Entity entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	public Entity findByPK(PK pk) {
		return entityManager.find(persistentClass, pk);
	}
	
	@SuppressWarnings("unchecked")
	public List<Entity> findAll() {
		Query query = entityManager.createQuery("FROM " + persistentClass.getCanonicalName());
		return query.getResultList();
	}
	
}

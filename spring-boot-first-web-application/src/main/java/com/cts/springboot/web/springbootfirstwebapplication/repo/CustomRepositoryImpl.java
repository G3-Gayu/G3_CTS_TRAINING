package com.cts.springboot.web.springbootfirstwebapplication.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;

@Repository
public class CustomRepositoryImpl  {

	@PersistenceContext
	EntityManager entityManager;

	
	public Employee findOneById(Long id) {
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM employee as em " + "WHERE em.id = ?",
				Employee.class);
		query.setParameter(1, id + "%");

		return (Employee) query.getResultList().get(0);
	}

}

package com.cts.springboot.web.springbootfirstwebapplication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("from employee where id=:id")
	public Optional<Employee> findOneById(@Param("id") Long id);

}

package com.cts.springboot.web.springbootfirstwebapplication.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.springboot.web.springbootfirstwebapplication.domain.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}

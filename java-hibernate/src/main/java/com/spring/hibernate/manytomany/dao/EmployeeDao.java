package com.spring.hibernate.manytomany.dao;

import com.spring.hibernate.manytomany.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    List<Employee> retrieveEmployeesByLastname(String lastname);
}

package com.livraison.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraison.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

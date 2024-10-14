package com.example.demo.service;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Employee;

@Repository
public interface EmployeeDao {
	public int persist(Record<Employee> record);
	public void showAll();
}

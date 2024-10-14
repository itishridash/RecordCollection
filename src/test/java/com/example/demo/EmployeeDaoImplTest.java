package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeDaoImpl;
import com.example.demo.service.RecordSequence;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoImplTest {
	@InjectMocks

	EmployeeDaoImpl employeeDAO = new EmployeeDaoImpl();

	@Mock

	JdbcTemplate jdbcTemplate;

@Test

public void testPersist() throws Exception{

RecordSequence<Employee> record = new RecordSequence<Employee>(); 
when(jdbcTemplate.update(anyString(), anyInt(), anyString(), anyString(), anyInt())).thenReturn(1);
record.add(new Employee (101, "Itishri", "HR", 100000));

record.add(new Employee (102, "Manjit", "HR", 120000)); assertEquals("Adding 2 element to record", record.size(), employeeDAO.persist(record));

verify(jdbcTemplate, times(2)).update(anyString(), anyInt(), anyString(), anyString(), anyInt()); }
}
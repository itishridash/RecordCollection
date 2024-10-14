package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired

	JdbcTemplate jdbcTemplate;

	@Override

	public int persist(Record<Employee> record) {
		String sql = "INSERT INTO Employee (id, name, department, salary) VALUES (?, ?, ?, ?";

		int recordsAdded = 0;

		for (int j = 0; j < record.size(); j++) {

			Employee emp = (Employee) record.getByIndex(j);

			int rowsInserted = jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getDepartment(),

					emp.getSalary());
			if (rowsInserted > 0) {

				recordsAdded = recordsAdded + rowsInserted;
			}
		}

		return recordsAdded;
	}

	@Override

	public void showAll() {

		String sql = "select from employee";

		System.out.println(jdbcTemplate.query(sql, (result, rowNum) -> new Employee(result.getInt("id"),

				result.getString("name"), result.getString("department"), result.getInt("salary"))));
	}
}
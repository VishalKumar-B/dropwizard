package com.motivity.RestExample.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.motivity.RestExample.core.Employee;

public class EmployeeService {

	private List<Employee> empList = new ArrayList<Employee>(
			Arrays.asList(new Employee("1", "vishal", "9876543210"), new Employee("2", "prashanth", "7654321098"),
					new Employee("3", "akhil", "8765432100"), new Employee("4", "ram", "9812374650")));

	public List<Employee> getAllEmployees() {
		return empList;
	}

	public Employee getEmployee(String id) {
		Employee employee = null;
		for (Employee e : empList) {
			if (e.getId().equals(id)) {
				employee = e;
			}
		}
		return employee;
	}

	public void addEmployee(Employee employee) {
		empList.add(employee);
	}

	public void updateEmployee(Employee employee, String id) {
		int i = 0;
		for (Employee e : empList) {
			if (e.getId().equals(id)) {
				empList.set(i, employee);
			}
			i++;
		}
	}

	public void deleteEmployuee(String id) {
		for (Employee e : empList) {
			if (e.getId().equals(id)) {
				empList.remove(e);
				break;
			}
		}
	}
}

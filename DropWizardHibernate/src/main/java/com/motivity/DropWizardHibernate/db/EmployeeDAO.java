package com.motivity.DropWizardHibernate.db;

import java.util.List;

import org.hibernate.SessionFactory;

import com.motivity.DropWizardHibernate.core.Employee;

import io.dropwizard.hibernate.AbstractDAO;

public class EmployeeDAO extends AbstractDAO<Employee> {

	public EmployeeDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return (List<Employee>) currentSession().createQuery("from Employee e").list();
	}

	public Employee getEmployee(String id) {
		return currentSession().get(Employee.class, id);
	}

	public Employee addEmployee(Employee employee) {
		Object o = currentSession().save(employee);
		return (Employee) o;
	}

	public void updateEmployee(Employee employee, String id) {
		currentSession().saveOrUpdate(employee);
	}

	public void deleteEmployee(Employee employee) {
		currentSession().delete(employee);
	}

}

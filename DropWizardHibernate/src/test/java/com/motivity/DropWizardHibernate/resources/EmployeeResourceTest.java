package com.motivity.DropWizardHibernate.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import com.motivity.DropWizardHibernate.core.Employee;
import com.motivity.DropWizardHibernate.db.EmployeeDAO;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;

@ExtendWith(DropwizardExtensionsSupport.class)
class EmployeeResourceTest {

	private static final EmployeeDAO DAO = mock(EmployeeDAO.class);
	private static final ResourceExtension EXT = ResourceExtension.builder().addResource(new EmployeeResource(DAO))
			.build();

	@Test
	void testGetAllEmployees() {

		Employee e1 = new Employee("1", "a", "123");
		Employee e2 = new Employee("2", "b", "456");
		doReturn(Arrays.asList(e1, e2)).when(DAO).getAllEmployees();
		List<Employee> emps = DAO.getAllEmployees();
		Assertions.assertEquals(2, emps.size(), "findAll should return 2 employees");
	}

	@Test
	void testAddEmployee() {

		Employee e1 = new Employee("1", "a", "123");
		doReturn(e1).when(DAO).addEmployee(any());
		Employee returnedEmployee = DAO.addEmployee(e1);
		Assertions.assertNotNull(returnedEmployee, "The saved Employee should not be null");
	}

	@Test
	void testGetEmployeeNotFound() {

		Employee e1 = new Employee("1", "a", "123");
		when(DAO.getEmployee("2")).thenReturn(null);
		Employee returnedEmployee = EXT.target("/employee/2").request().get(Employee.class);
		Assertions.assertNotEquals(e1, returnedEmployee, "employee should not return");
		verify(DAO).getEmployee("2");
	}

	@Test
	void testGetEmployee() {
		Employee employee = new Employee("1", "a", "123");
		when(DAO.getEmployee("1")).thenReturn(employee);
		Employee found = EXT.target("/employee/1").request().get(Employee.class);
		Assertions.assertEquals(found.getId(), employee.getId(), "employee should return");
		verify(DAO).getEmployee("1");
	}

}

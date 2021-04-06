package com.motivity.DropWizardHibernate.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.motivity.DropWizardHibernate.core.Employee;
import com.motivity.DropWizardHibernate.core.Manager;
import com.motivity.DropWizardHibernate.db.EmployeeDAO;

import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class EmployeeResource {

	private EmployeeDAO employeeDAO;

	public EmployeeResource(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@GET
	public String welcome() {
		return "welcome to employees page";
	}

	@GET
	@UnitOfWork
	@Path("/employees")
	public List<Employee> getEmployees(@Auth Manager manager) {
		return employeeDAO.getAllEmployees();
	}

	@GET
	@UnitOfWork
	@Path("/employee/{id}")
	public Employee getEmployee(@PathParam(value = "id") String id, @Auth Manager manager) {
		return employeeDAO.getEmployee(id);
	}

	@POST
	@UnitOfWork
	@Path("/add")
	public Response addEmployee( Employee employee) {
		employeeDAO.addEmployee(employee);
		return Response.ok("success").build();
	}

	@PUT
	@UnitOfWork
	@Path("/update/{id}")
	public void updateEmployee(Employee employee, @PathParam(value = "id") String id) {
		employeeDAO.updateEmployee(employee, id);
	}

	@DELETE
	@UnitOfWork
	@Path("/delete/{id}")
	public void deleteEmployee(@PathParam(value = "id") String id, @Auth Manager manager) {
		employeeDAO.deleteEmployee(employeeDAO.getEmployee(id));
	}
}

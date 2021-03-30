package com.motivity.DropWizardJDBI3.resources;

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

import com.motivity.DropWizardJDBI3.core.Employee;
import com.motivity.DropWizardJDBI3.db.EmployeeDAO;

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
	@Path("/employees")
	public List<Employee> getEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@GET
	@Path("/employee/{id}")
	public Employee getEmployee(@PathParam(value = "id") String id) {
		return employeeDAO.getEmployee(id);
	}

	@POST
	@Path("/add")
	public Response addEmployee(Employee employee) {
		return Response.ok(employeeDAO.addEmployee(employee)).build();
	}

	@PUT
	@Path("/update/{id}")
	public Response updateEmployee(Employee employee, @PathParam(value = "id") String id) {
		return Response.ok(employeeDAO.updateEmployee(employee, id)).build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deleteEmployee(@PathParam(value = "id") String id) {
		return Response.ok(employeeDAO.deleteEmployuee(id)).build();
	}
}

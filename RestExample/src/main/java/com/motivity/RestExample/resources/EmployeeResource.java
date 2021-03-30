package com.motivity.RestExample.resources;

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

import com.motivity.RestExample.core.Employee;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class EmployeeResource {

	private EmployeeService employeeService;

	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GET
	public String welcome() {
		return "welcome to employees page";
	}

	@GET
	@Path("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@GET
	@Path("/employee/{id}")
	public Employee getEmployee(@PathParam(value = "id") String id) {
		return employeeService.getEmployee(id);
	}

	@POST
	@Path("/add")
	public void addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
	}

	@PUT
	@Path("/update/{id}")
	public void updateEmployee(Employee employee, @PathParam(value = "id") String id) {
		employeeService.updateEmployee(employee, id);
	}

	@DELETE
	@Path("/delete/{id}")
	public void deleteEmployee(@PathParam(value = "id") String id) {
		employeeService.deleteEmployuee(id);
	}
}

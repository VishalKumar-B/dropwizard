package com.motivity.DropWizardJDBI3.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee map(ResultSet rs, StatementContext ctx) throws SQLException {
		return new Employee(
				rs.getString("id"), 
				rs.getString("name"), 
				rs.getString("mobileNumber")
				);
	}

}

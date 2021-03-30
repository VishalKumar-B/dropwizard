package com.motivity.DropWizardJDBI.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class EmployeeMapper implements ResultSetMapper<Employee>{

	@Override
	public Employee map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new Employee(
				r.getString("id"),
				r.getString("name"),
				r.getString("mobileNumber")
				);
	}

}

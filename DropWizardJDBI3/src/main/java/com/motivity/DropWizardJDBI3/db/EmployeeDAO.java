package com.motivity.DropWizardJDBI3.db;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.motivity.DropWizardJDBI3.core.Employee;
import com.motivity.DropWizardJDBI3.core.EmployeeMapper;

@RegisterRowMapper(EmployeeMapper.class)
public interface EmployeeDAO {

	@SqlQuery("select * from employee")
	List<Employee> getAllEmployees();
	
	@SqlQuery("select * from employee where id = :id")
	Employee getEmployee(@Bind("id") String id);

	@SqlUpdate("insert into employee (id, name, mobileNumber) values (:id, :name, :mobileNumber)")
	int addEmployee(@BindBean Employee employee);

	@SqlUpdate("update employee set name = :name, mobileNumber = :mobileNumber where id = :id")
	int updateEmployee(@BindBean Employee employee, String id);

	@SqlUpdate("delete from employee where id = :id")
	int deleteEmployuee(@Bind("id") String id);
	
}

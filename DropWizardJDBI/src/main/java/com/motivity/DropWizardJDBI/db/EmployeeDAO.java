package com.motivity.DropWizardJDBI.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.motivity.DropWizardJDBI.core.Employee;
import com.motivity.DropWizardJDBI.core.EmployeeMapper;

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDAO {

	@SqlQuery("select * from employee")
	List<Employee> getAllEmployees();
	
	@SqlQuery("select * from employee where id = :id")
	public Employee getEmployee(@Bind("id") String id);

	@SqlUpdate("insert into employee (id, name, mobileNumber) values (:id, :name, :mobileNumber)")
	int addEmployee(@BindBean Employee employee);

	@SqlUpdate("update employee set name = :name, mobileNumber = :mobileNumber where id = :id")
	void updateEmployee(@BindBean Employee employee, String id);

	@SqlUpdate("delete from employee where id = :id")
	int deleteEmployuee(@Bind("id") String id);

	
}

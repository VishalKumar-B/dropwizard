package com.motivity.DropWizardJDBI;

import org.skife.jdbi.v2.DBI;

import com.motivity.DropWizardJDBI.db.EmployeeDAO;
import com.motivity.DropWizardJDBI.resources.EmployeeResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardJDBIApplication extends Application<DropWizardJDBIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardJDBIApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardJDBI";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardJDBIConfiguration> bootstrap) {
      
    }

    @Override
    public void run(final DropWizardJDBIConfiguration configuration,
                    final Environment environment) {
    	final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "sql");

        final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);
        final EmployeeResource employeeResource = new EmployeeResource(employeeDAO);

        environment.jersey().register(employeeResource);
    }

}

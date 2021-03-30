package com.motivity.DropWizardJDBI3;

import org.jdbi.v3.core.Jdbi;

import com.motivity.DropWizardJDBI3.db.EmployeeDAO;
import com.motivity.DropWizardJDBI3.resources.EmployeeResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardJDBI3Application extends Application<DropWizardJDBI3Configuration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardJDBI3Application().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardJDBI3";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardJDBI3Configuration> bootstrap) {
        
    }

    @Override
    public void run(final DropWizardJDBI3Configuration configuration,
                    final Environment environment) {
       final JdbiFactory jdbiFactory = new JdbiFactory();
       final Jdbi jdbi = jdbiFactory.build(environment, configuration.getDataSourceFactory(), "mySql");
       
       final EmployeeDAO employeeDAO = jdbi.onDemand(EmployeeDAO.class);
       final EmployeeResource employeeResource = new EmployeeResource(employeeDAO);
       
       environment.jersey().register(employeeResource);
    }

}

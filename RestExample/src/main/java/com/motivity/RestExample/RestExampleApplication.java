package com.motivity.RestExample;

import com.motivity.RestExample.resources.EmployeeResource;
import com.motivity.RestExample.resources.EmployeeService;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestExampleApplication extends Application<RestExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RestExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "RestExample";
    }

    @Override
    public void initialize(final Bootstrap<RestExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final RestExampleConfiguration configuration,
                    final Environment environment) {
    	
    	final EmployeeService employeeService = new EmployeeService();
    	final EmployeeResource employeeResource = new EmployeeResource(employeeService);
    	
    	environment.jersey().register(employeeResource);
    }

}

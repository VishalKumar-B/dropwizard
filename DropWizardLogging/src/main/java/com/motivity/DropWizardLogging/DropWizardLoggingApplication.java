package com.motivity.DropWizardLogging;

import com.motivity.DropWizardLogging.resources.ExampleResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardLoggingApplication extends Application<DropWizardLoggingConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardLoggingApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizardLogging";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardLoggingConfiguration> bootstrap) {
        
    }

    @Override
    public void run(final DropWizardLoggingConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new ExampleResource());
    }

}

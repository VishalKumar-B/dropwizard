package com.motivity.Example2;

import com.motivity.Example2.resources.Example2Resource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Example2Application extends Application<Example2Configuration> {

    public static void main(final String[] args) throws Exception {
        new Example2Application().run(args);
    }

    @Override
    public String getName() {
        return "Example2";
    }

    @Override
    public void initialize(final Bootstrap<Example2Configuration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final Example2Configuration configuration,
                    final Environment environment) throws Exception {
        environment.jersey().register(new Example2Resource());
    }

}

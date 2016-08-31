package com.lakhi.file;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.lakhi.file.resources.fileResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class configApplication extends Application<configConfiguration> {

    public static void main(final String[] args) throws Exception {
        new configApplication().run(args);
    }

    @Override
    public String getName() {
        return "config";
    }

    @Override
    public void initialize(final Bootstrap<configConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final configConfiguration configuration,
                    final Environment environment) {
        
    	environment.jersey().register(MultiPartFeature.class);
    	final fileResource fr = new fileResource();
    	environment.jersey().register(fr);
    	
    }

}

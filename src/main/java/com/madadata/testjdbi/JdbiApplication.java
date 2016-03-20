package com.madadata.testjdbi;


import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;

import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

/**
 * Created by lixinyi on 16/3/18.
 */
public class JdbiApplication extends Application<JdbiConfiguration> {


    public static void main(String[] args) throws Exception {
        new JdbiApplication().run(args);
    }

    @Override
    public void run(JdbiConfiguration config, Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "sqlite");
        final MyDAO dao = jdbi.onDemand(MyDAO.class);
        dao.createUserProfileTable();

        dao.insert(1, "jetty","chen","2ljljas@123.com",14);
        environment.jersey().register(new UserResource(dao));
    }
}

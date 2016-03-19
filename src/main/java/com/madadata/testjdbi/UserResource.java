package com.madadata.testjdbi;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Strings;
import io.dropwizard.jersey.params.IntParam;
import org.hibernate.validator.constraints.NotEmpty;


import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by lixinyi on 16/3/19.
 * <p>
 * http://host:port/path?query
 * <p>
 * query param: host:port/users?id=1
 * path param: host:port/users/1
 */
@Path("/database")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final MyDAO dao;

    public UserResource(MyDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public UserProfile getUserProfileById(@PathParam("id") @NotNull IntParam id) {
        return dao.findUserProfileById(id.get());
    }
//
//    @GET
//    @Timed
//    public String findResultById(@PathParam("name") String name,@PathParam("email") String email,@PathParam("gender") String gender) {
//        Integer integer = id.get();
//        if (integer == null) {
//            throw new WebApplicationException("id cannot be null");
//        }
//        String name = dao.findNameById(id.get());
//        if (Strings.isNullOrEmpty(name)) {
//            throw new WebApplicationException("cannot find name");
//        }
//        return name;
//    }
}

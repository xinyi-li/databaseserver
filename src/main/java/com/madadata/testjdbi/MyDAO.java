package com.madadata.testjdbi;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.util.StringColumnMapper;

/**
 * Created by lixinyi on 16/3/19.
 */
public interface MyDAO {

    @SqlUpdate("create table if not exists something (id int primary key, name varchar(100))")
    void createSomethingTable();

    @SqlUpdate("create table if not exists users (" +
            "id int primary key, " +
            "firstName varchar(40) not null, " +
            "lastName varchar(40) not null, " +
            "age int not null, " +
            "email varchar(40) not null)")
    void createUserProfileTable();

    @SqlUpdate("insert or ignore into something (id, name) values (:id, :name)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("email") String email,
                @Bind("gender") String gender);

    @SqlQuery("select name from something where id = :id")
    String findNameById(@Bind("id") int id);

    @RegisterMapper(UserProfileMapper.class)
    @SqlQuery("select firstName, lastName, email, age from users where id = :id")
    UserProfile findUserProfileById(@Bind("id") int id);

}


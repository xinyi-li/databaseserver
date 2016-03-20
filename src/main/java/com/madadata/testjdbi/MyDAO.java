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

   //@SqlUpdate("create table if not exists something (id int primary key, Lastname varchar(30)),Firstname varchar(30),email varchar(30),age int")
    //void createSomethingTable();

    @SqlUpdate("create table if not exists users (" +
            "id int primary key, " +
            "Lastname varchar(40) not null, " +
            "Firstname varchar(40) not null, " +
            "email varchar(40) not null, " +
            "age int not null)")
    void createUserProfileTable();

    @SqlUpdate("insert or ignore into users (id, Lastname,Firstname,email,age) values (:id, :Lastname, :Firstname, :email, :age)")
    void insert(@Bind("id") int id, @Bind("Lastname") String Lastname, @Bind("Firstname") String Firstname, @Bind("email") String email,
                @Bind("age") int age);

   // @SqlQuery("select name from something where id = :id")
    //String findNameById(@Bind("id") int id);

    @RegisterMapper(UserProfileMapper.class)
    @SqlQuery("select Lastname, Firstname, age, email from users where id = :id")
    UserProfile findUserProfileById(@Bind("id") int id);

}


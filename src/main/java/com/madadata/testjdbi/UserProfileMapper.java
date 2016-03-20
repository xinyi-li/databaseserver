package com.madadata.testjdbi;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lixinyi on 16/3/19.
 */
public class UserProfileMapper implements ResultSetMapper<UserProfile> {

    public UserProfile map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new UserProfile(resultSet.getString("Lastname"),resultSet.getString("Firstname"),resultSet.getString("email"),resultSet.getInt("age"));
    }

}

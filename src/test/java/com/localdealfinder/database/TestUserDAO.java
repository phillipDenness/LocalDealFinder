package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestUserDAO {
    private UserDAO userDAO;
    private User user;

    @Before
    public void setup(){
        userDAO = new UserDAO();
        user = new User().withAlias("junit_user");
    }

    @Test
    public void testReadAllUsersSuccess() throws SQLException {
        Optional<List<User>> optionalUsers = userDAO.readAll();

        assertTrue(optionalUsers.isPresent());
    }

    @Test
    public void testCreateUserSuccess(){
        boolean success = userDAO.create(user);
        assertTrue(success);
    }

    @Test
    public void testReadUserWithIdSuccess() throws SQLException {
        User user = new User().withId(1);
        Optional<User> optionalUser = userDAO.read(user);

        assertTrue(optionalUser.isPresent());
    }

    @Test
    public void testReadUserWithAliasSuccess() throws SQLException {
        Optional<User> optionalUser = userDAO.read(user);

        assertTrue(optionalUser.isPresent());
    }

    @Test
    public void testDeleteUserWithAliasSuccess(){
        boolean success = userDAO.delete(user);
        assertTrue(success);
    }
}

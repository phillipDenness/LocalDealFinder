package com.localdealfinder.database;

import com.localdealfinder.model.Search;
import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class TestUserSearchJnDAO {
    private UserSearchJnDAO dao;

    @Before
    public void setup(){
        dao = new UserSearchJnDAO();
    }

    @Test
    public void testReadAllUserWithNamePositiveMatchSuccess() throws SQLException {
        User user = dao.readAll(new User().withAlias("test_user"));

        assertTrue(user.getSearches().size()==3);
    }

    @Test
    public void testAddSearchToUserWithNameSuccess(){
        boolean success = dao.create(new User().withAlias("test_user"), new Search().withId(3));
        assertTrue(success);
    }

    @Test
    public void testDeleteUserSearchWithNamePositiveMatchSuccess(){
        boolean success = dao.delete(new User().withAlias("test_user"), new Search().withId(3));
        assertTrue(success);
    }
}

package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class TestUserPositiveMatchJnDAO {
    private UserPositiveMatchJnDAO userPositiveMatchJnDAO;
    private PositiveMatch positiveMatch;
    private User user;

    @Before
    public void setup(){
        userPositiveMatchJnDAO = new UserPositiveMatchJnDAO();
        positiveMatch = new PositiveMatch().withId(12);
        user = new User().withId(1);
    }

    @Test
    public void testReadAllUserPositiveMatchSuccess() throws SQLException {
        User user = userPositiveMatchJnDAO.readAll(new User().withId(2));

        assertTrue(user.getPositiveMatches().size()==1);
    }

    @Test
    public void testCreateUserPositiveMatchSuccess(){
        boolean success = userPositiveMatchJnDAO.create(user, positiveMatch);
        assertTrue(success);
    }

    @Test
    public void testDeleteUserPositiveMatchSuccess(){
        boolean success = userPositiveMatchJnDAO.delete(user, positiveMatch);
        assertTrue(success);
    }
}

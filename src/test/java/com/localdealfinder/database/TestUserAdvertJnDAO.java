package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class TestUserAdvertJnDAO {
    private UserAdvertJnDAO userAdvertJnDAO;
    private Advert advert;
    private User user;

    @Before
    public void setup(){
        userAdvertJnDAO = new UserAdvertJnDAO();
        advert = new Advert().withId(2);
        user = new User().withId(2);
    }

    @Test
    public void testReadAllUserAdvertsSuccess() throws SQLException {
        User user = userAdvertJnDAO.readAll(new User().withId(1));

        assertTrue(user.getAdverts().size()==1);
    }

    @Test
    public void testCreateUserAdvertJnSuccess(){
        boolean success = userAdvertJnDAO.create(user, advert);
        assertTrue(success);
    }

    @Test
    public void testDeleteUserAdvertSuccess(){
        boolean success = userAdvertJnDAO.delete(user, advert);
        assertTrue(success);
    }
}

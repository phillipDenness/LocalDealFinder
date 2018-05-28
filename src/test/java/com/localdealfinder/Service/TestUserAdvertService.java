package com.localdealfinder.Service;

import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestUserAdvertService {
    private UserAdvertService userAdvertService;

    @Before
    public void setUp() {
        userAdvertService = UserAdvertService.getInstance();
    }

    @Test
    public void testCreateUserAdvertSuccess() {
        boolean success = userAdvertService.create(1, 2);
        assertTrue(success);
    }

    @Test
    public void testReadAllUserAdvertsSuccess() {
        User user = userAdvertService.readAll(1);
        assertTrue(user.getAdverts().size()==1);
    }

    @Test
    public void testDeleteUserAdvertSuccess() {
        boolean success = userAdvertService.delete(1,2);
        assertTrue(success);
    }

}

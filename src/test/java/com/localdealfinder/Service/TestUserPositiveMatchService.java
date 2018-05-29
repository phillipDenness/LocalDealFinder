package com.localdealfinder.Service;

import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestUserPositiveMatchService {
    private UserPositiveMatchService userPositiveMatchService;

    @Before
    public void setUp() {
        userPositiveMatchService = UserPositiveMatchService.getInstance();
    }

    @Test
    public void testCreateUserPositiveMatchSuccess() {
        boolean success = userPositiveMatchService.create(1, 12);
        assertTrue(success);
    }

    @Test
    public void testReadAllUserPositiveMatchSuccess() {
        User user = userPositiveMatchService.readAll(2);
        assertTrue(user.getPositiveMatches().size()==1);
    }

    @Test
    public void testDeleteUserPositiveMatchSuccess() {
        boolean success = userPositiveMatchService.delete(1,12);
        assertTrue(success);
    }
}

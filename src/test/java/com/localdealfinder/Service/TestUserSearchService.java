package com.localdealfinder.Service;

import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestUserSearchService {
    private UserSearchService service;

    @Before
    public void setUp() {
        service = UserSearchService.getInstance();
    }

    @Test
    public void testCreateUserPositiveMatchSuccess() {
        boolean success = service.create("test_user", 3);
        assertTrue(success);
    }

    @Test
    public void testReadAllUserPositiveMatchSuccess() {
        User user = service.readAll("test_user");
        System.out.println(user.getSearches().size());
        assertTrue(user.getSearches().size()==2);
    }

    @Test
    public void testDeleteUserPositiveMatchSuccess() {
        boolean success = service.delete("test_user",3);
        assertTrue(success);
    }
}

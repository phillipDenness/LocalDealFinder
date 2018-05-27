package com.localdealfinder.Service;

import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestUserService {
    private UserService userService;

    @Before
    public void setUp() {
        userService = UserService.getInstance();
    }

    @Test
    public void testCreateUserInServiceSuccess() {
        boolean success = userService.create("junit_alias_service");
        assertTrue(success);
    }

    @Test
    public void testReadUserUsingAliasSuccess() {
        Optional<User> userOptional = userService.read("junit_alias_service");
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void testReadUserUsingIdSuccess() {
        Optional<User> userOptional = userService.read(1);
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void testReadAllUserSuccess() {
        Optional<List<User>> userOptional = userService.readAll();
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void testDeleteUserSuccess() {
        boolean success = userService.delete("junit_alias_service");
        assertTrue(success);
    }
}

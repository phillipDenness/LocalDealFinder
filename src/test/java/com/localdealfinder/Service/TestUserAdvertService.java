package com.localdealfinder.Service;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

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
        Optional<List<Advert>> userAdverts = userAdvertService.readAll(1);
        assertTrue(userAdverts.isPresent());
    }

    @Test
    public void testDeleteUserAdvertSuccess() {
        boolean success = userAdvertService.delete(1,2);
        assertTrue(success);
    }

}

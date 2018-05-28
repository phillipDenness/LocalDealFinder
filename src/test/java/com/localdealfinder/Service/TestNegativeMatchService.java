package com.localdealfinder.Service;

import com.localdealfinder.model.NegativeMatch;
import com.localdealfinder.model.PositiveMatch;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestNegativeMatchService {
    private NegativeMatchService service;

    @Before
    public void setUp() {
        service = NegativeMatchService.getInstance();
    }

    @Test
    public void testCreatePositiveMatchInServiceSuccess() {
        boolean success = service.create("JUNIT_TEST");
        assertTrue(success);
    }

    @Test
    public void testReadPositiveMatchUsingLinkSuccess() {
        Optional<NegativeMatch> negativeMatchOptional = service.read("JUNIT_TEST");
        assertTrue(negativeMatchOptional.isPresent());
    }

    @Test
    public void testReadPositiveMatchUsingIdSuccess() {
        Optional<NegativeMatch> negativeMatchOptional = service.read(1);
        assertTrue(negativeMatchOptional.isPresent());
    }

    @Test
    public void testReadAllPositiveMatchSuccess() {
        Optional<List<NegativeMatch>> negativeMatchOptional = service.readAll();
        assertTrue(negativeMatchOptional.isPresent());
    }

    @Test
    public void testDeletePositiveMatchSuccess() {
        boolean success = service.delete("JUNIT_TEST");
        assertTrue(success);
    }
}

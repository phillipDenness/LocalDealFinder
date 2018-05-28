package com.localdealfinder.Service;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.PositiveMatch;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestPositiveMatchService {
    private PositiveMatchService positiveMatchService;

    @Before
    public void setUp() {
        positiveMatchService = PositiveMatchService.getInstance();
    }

    @Test
    public void testCreatePositiveMatchInServiceSuccess() {
        boolean success = positiveMatchService.create("JUNIT_TEST");
        assertTrue(success);
    }

    @Test
    public void testReadPositiveMatchUsingLinkSuccess() {
        Optional<PositiveMatch> positiveMatchOptional = positiveMatchService.read("JUNIT_TEST");
        assertTrue(positiveMatchOptional.isPresent());
    }

    @Test
    public void testReadPositiveMatchUsingIdSuccess() {
        Optional<PositiveMatch> positiveMatchOptional = positiveMatchService.read(1);
        assertTrue(positiveMatchOptional.isPresent());
    }

    @Test
    public void testReadAllPositiveMatchSuccess() {
        Optional<List<PositiveMatch>> positiveMatchOptional = positiveMatchService.readAll();
        assertTrue(positiveMatchOptional.isPresent());
    }

    @Test
    public void testDeletePositiveMatchSuccess() {
        boolean success = positiveMatchService.delete("JUNIT_TEST");
        assertTrue(success);
    }
}

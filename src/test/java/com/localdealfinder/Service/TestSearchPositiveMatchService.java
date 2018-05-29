package com.localdealfinder.Service;

import com.localdealfinder.model.Search;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestSearchPositiveMatchService {
    private SearchPositiveMatchService service;

    @Before
    public void setUp() {
        service = SearchPositiveMatchService.getInstance();
    }

    @Test
    public void testCreateSearchPositiveMatchSuccess() {
        boolean success = service.create(1, 12);
        assertTrue(success);
    }

    @Test
    public void testReadAllSearchPositiveMatchSuccess() {
        Search search = service.readAll(1);
        assertTrue(search.getPositiveMatches().size()==3);
    }

    @Test
    public void testDeleteSearchPositiveMatchSuccess() {
        boolean success = service.delete(1,12);
        assertTrue(success);
    }
}

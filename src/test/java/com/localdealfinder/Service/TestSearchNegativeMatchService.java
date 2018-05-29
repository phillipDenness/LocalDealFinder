package com.localdealfinder.Service;

import com.localdealfinder.model.Search;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestSearchNegativeMatchService {
    private SearchNegativeMatchService service;

    @Before
    public void setUp() {
        service = SearchNegativeMatchService.getInstance();
    }

    @Test
    public void testCreateSearchNegativeMatchSuccess() {
        boolean success = service.create(1, 4);
        assertTrue(success);
    }

    @Test
    public void testReadAllSearchNegativeMatchSuccess() {
        Search search = service.readAll(1);
        assertTrue(search.getNegativeMatches().size()==3);
    }

    @Test
    public void testDeleteSearchNegativeMatchSuccess() {
        boolean success = service.delete(1,4);
        assertTrue(success);
    }
}

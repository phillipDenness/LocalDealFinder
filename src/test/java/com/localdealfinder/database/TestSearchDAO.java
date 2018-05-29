package com.localdealfinder.database;

import com.localdealfinder.model.Search;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestSearchDAO {
    private SearchDAO dao;
    private Search search;

    @Before
    public void setup(){
        dao = new SearchDAO();
        search = new Search().withName("testTitle")
                .withLocation("Sheffield")
                .withMaxPrice(99.99)
                .withMinPrice(50.00);
    }

    @Test
    public void testReadAllSuccess() throws SQLException {
        Optional<List<Search>> advertsOptional = dao.readAll();

        assertTrue(advertsOptional.isPresent());
    }

    @Test
    public void testCreateAdvertSuccess(){
        boolean success = dao.create(search);
        assertTrue(success);
    }

    @Test
    public void testReadAdvertWithIdSuccess() throws SQLException {
        Search search = new Search().withId(1);
        Optional<Search> optionalSearch = dao.read(search);

        assertTrue(optionalSearch.isPresent());
    }
}

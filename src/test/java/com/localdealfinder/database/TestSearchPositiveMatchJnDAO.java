package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class TestSearchPositiveMatchJnDAO {
    private SearchPositiveMatchJnDAO dao;
    private PositiveMatch positiveMatch;
    private Search search;

    @Before
    public void setup(){
        dao = new SearchPositiveMatchJnDAO();
        positiveMatch = new PositiveMatch().withId(8);
        search = new Search().withId(1);
    }

    @Test
    public void testReadAllUserPositiveMatchSuccess() throws SQLException {
        Search search = dao.readAll(new Search().withId(1));
        assertTrue(search.getPositiveMatches().size()==3);
    }

    @Test
    public void testCreateSearchPositiveMatchSuccess(){
        boolean success = dao.create(search, positiveMatch);
        assertTrue(success);
    }

    @Test
    public void testDeleteSearchPositiveMatchSuccess(){
        boolean success = dao.delete(search, positiveMatch);
        assertTrue(success);
    }
}

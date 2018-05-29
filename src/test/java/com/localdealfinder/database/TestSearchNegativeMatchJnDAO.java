package com.localdealfinder.database;

import com.localdealfinder.model.NegativeMatch;
import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;

public class TestSearchNegativeMatchJnDAO {
    private SearchNegativeMatchJnDAO dao;
    private NegativeMatch negativeMatch;
    private Search search;

    @Before
    public void setup(){
        dao = new SearchNegativeMatchJnDAO();
        negativeMatch = new NegativeMatch().withId(4);
        search = new Search().withId(1);
    }

    @Test
    public void testReadAllUserNegativeMatchSuccess() throws SQLException {
        Search search = dao.readAll(new Search().withId(1));
        assertTrue(search.getNegativeMatches().size()==3);
    }

    @Test
    public void testCreateSearchNegativeMatchSuccess(){
        boolean success = dao.create(search, negativeMatch);
        assertTrue(success);
    }

    @Test
    public void testDeleteSearchNegativeMatchSuccess(){
        boolean success = dao.delete(search, negativeMatch);
        assertTrue(success);
    }
}

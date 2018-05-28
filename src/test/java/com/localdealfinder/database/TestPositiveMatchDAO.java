package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestPositiveMatchDAO {
    private PositiveMatchDAO positiveMatchDAO;
    private PositiveMatch positiveMatch;

    @Before
    public void setup(){
        positiveMatchDAO = new PositiveMatchDAO();
        positiveMatch = new PositiveMatch().withName("JUNIT_TEST1");
    }

    @Test
    public void testReadAllPositiveMatchesSuccess() throws SQLException {
        Optional<List<PositiveMatch>> advertsOptional = positiveMatchDAO.readAll();

        assertTrue(advertsOptional.isPresent());
    }

    @Test
    public void testCreateAdvertSuccess(){
        boolean success = positiveMatchDAO.create(positiveMatch);
        assertTrue(success);
    }

    @Test
    public void testReadAdvertWithIdSuccess() throws SQLException {
        PositiveMatch positiveMatch = new PositiveMatch().withId(1);
        Optional<PositiveMatch> optionalAdvert = positiveMatchDAO.read(positiveMatch);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testReadAdvertWithLinkSuccess() throws SQLException {
        Optional<PositiveMatch> optionalAdvert = positiveMatchDAO.read(positiveMatch);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testDeleteAdvertSuccess(){
        boolean success = positiveMatchDAO.delete(positiveMatch);
        assertTrue(success);
    }
}

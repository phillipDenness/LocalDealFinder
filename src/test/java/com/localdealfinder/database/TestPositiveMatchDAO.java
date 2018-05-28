package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestPositiveMatchDAO {
    private PositiveMatchDAO dao;
    private PositiveMatch positiveMatch;

    @Before
    public void setup(){
        dao = new PositiveMatchDAO();
        positiveMatch = new PositiveMatch().withName("JUNIT_TEST1");
    }

    @Test
    public void testReadAllPositiveMatchesSuccess(){
        Optional<List<PositiveMatch>> advertsOptional = dao.readAll();

        assertTrue(advertsOptional.isPresent());
    }

    @Test
    public void testCreatePositiveMatchSuccess(){
        boolean success = dao.create(positiveMatch);
        assertTrue(success);
    }

    @Test
    public void testReadPositiveMatchWithIdSuccess() throws SQLException {
        PositiveMatch positiveMatch = new PositiveMatch().withId(1);
        Optional<PositiveMatch> optionalAdvert = dao.read(positiveMatch);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testReadPositiveMatchWithLinkSuccess() throws SQLException {
        Optional<PositiveMatch> optionalAdvert = dao.read(positiveMatch);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testDeletePositiveMatchSuccess(){
        boolean success = dao.delete(positiveMatch);
        assertTrue(success);
    }
}

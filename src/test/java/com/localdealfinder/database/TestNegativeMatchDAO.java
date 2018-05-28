package com.localdealfinder.database;

import com.localdealfinder.model.NegativeMatch;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestNegativeMatchDAO {
    private NegativeMatchDAO dao;
    private NegativeMatch negativeMatch;

    @Before
    public void setup(){
        dao = new NegativeMatchDAO();
        negativeMatch = new NegativeMatch().withName("JUNIT_TEST1");
    }

    @Test
    public void testReadAllNegativeMatchesSuccess() {
        Optional<List<NegativeMatch>> advertsOptional = dao.readAll();

        assertTrue(advertsOptional.isPresent());
    }

    @Test
    public void testCreateNegativeMatchSuccess(){
        boolean success = dao.create(negativeMatch);
        assertTrue(success);
    }

    @Test
    public void testReadNegativeMatchWithIdSuccess() throws SQLException {
        NegativeMatch negativeMatch = new NegativeMatch().withId(1);
        Optional<NegativeMatch> optionalAdvert = dao.read(negativeMatch);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testReadNegativeMatchWithLinkSuccess() throws SQLException {
        Optional<NegativeMatch> optionalAdvert = dao.read(negativeMatch);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testDeleteNegativeMatchSuccess(){
        boolean success = dao.delete(negativeMatch);
        assertTrue(success);
    }
}

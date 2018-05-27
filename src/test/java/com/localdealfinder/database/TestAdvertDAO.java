package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestAdvertDAO {
    private AdvertDAO advertDAO;
    private Advert advert;

    @Before
    public void setup(){
        advertDAO = new AdvertDAO();
        advert = new Advert().withTitle("testTitle")
                .withLink("http://foo.bar/b")
                .withPrice(99.99);
    }

    @Test
    public void testReadAllSuccess() throws SQLException {
        Optional<List<Advert>> advertsOptional = advertDAO.readAll();

        assertTrue(advertsOptional.isPresent());
    }

    @Test
    public void testCreateAdvertSuccess(){
        boolean success = advertDAO.create(advert);
        assertTrue(success);
    }

    @Test
    public void testReadAdvertWithIdSuccess() throws SQLException {
        Advert advert = new Advert().withId(1);
        Optional<Advert> optionalAdvert = advertDAO.read(advert);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testReadAdvertWithLinkSuccess() throws SQLException {
        Optional<Advert> optionalAdvert = advertDAO.read(advert);

        assertTrue(optionalAdvert.isPresent());
    }

    @Test
    public void testDeleteAdvertSuccess(){
        boolean success = advertDAO.delete(advert);
        assertTrue(success);
    }
}

package com.shopperapp;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class TestAdvertDAO {
    private AdvertDAO advertDAO;

    @Before
    public void setup(){
        advertDAO = new AdvertDAO();
    }

    @Test
    public void testReadAllSuccess() throws SQLException {
        Optional<List<Advert>> advertsOptional = advertDAO.readAll();

        assertTrue(advertsOptional.isPresent());
        System.out.println(advertsOptional.get().get(0).getTitle());
    }
}

package com.localdealfinder.Service;

import com.localdealfinder.Advert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

public class AdvertServiceTest {
    private AdvertService advertService;

    @Before
    public void setUp() {
        advertService = AdvertService.getInstance();
    }

    @Test
    public void testCreateAdvertInServiceSuccess() {
        boolean success = advertService.create("title_name_2", 22.00, "http://bar.foo.com/h");
        assertTrue(success);
    }

    @Test
    public void testReadAdvertUsingLinkSuccess() {
        Optional<Advert> advertOptional = advertService.read("http://bar.foo.com/h");
        assertTrue(advertOptional.isPresent());
    }

    @Test
    public void testReadAdvertUsingIdSuccess() {
        Optional<Advert> advertOptional = advertService.read(1);
        assertTrue(advertOptional.isPresent());
    }

    @Test
    public void testReadAllAdvertsSuccess() {
        Optional<List<Advert>> advertsOptional = advertService.readAll();
        assertTrue(advertsOptional.isPresent());
    }

    @Test
    public void testDeleteAdvertSuccess() {
        boolean success = advertService.delete("http://bar.foo.com/h");
        assertTrue(success);
    }
}
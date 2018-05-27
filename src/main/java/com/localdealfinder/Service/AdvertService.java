package com.localdealfinder.Service;

import com.localdealfinder.model.Advert;
import com.localdealfinder.database.AdvertDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdvertService {

    private static final AdvertService INSTANCE = new AdvertService();

    private AdvertDAO dao;

    private AdvertService() {
        this.dao = new AdvertDAO();
    }

    public static AdvertService getInstance() {
        return INSTANCE;
    }

    public boolean create(String title, double price, String link){
        Advert advert = new Advert().withTitle(title)
                .withPrice(price)
                .withLink(link);

        return dao.create(advert);
    }

    public Optional<Advert> read(int id) throws IllegalArgumentException{

        Optional<Advert> advertOptional = null;
        try {
            advertOptional = dao.read( new Advert().withId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertOptional;
    }

    public Optional<Advert> read(String link) throws IllegalArgumentException{

        Optional<Advert> advertOptional = null;
        try {
            advertOptional = dao.read(new Advert().withLink(link));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertOptional;
    }

    public Optional<List<Advert>> readAll(){
        Optional<List<Advert>> advertsOptional = null;
        try {
            advertsOptional = dao.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertsOptional;
    }

    public boolean delete(String link){
        return dao.delete(new Advert().withLink(link));
    }
}

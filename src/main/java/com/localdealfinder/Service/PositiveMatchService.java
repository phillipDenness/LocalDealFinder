package com.localdealfinder.Service;

import com.localdealfinder.database.PositiveMatchDAO;
import com.localdealfinder.model.PositiveMatch;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PositiveMatchService {
    private static final PositiveMatchService INSTANCE = new PositiveMatchService();

    private PositiveMatchDAO dao;

    private PositiveMatchService() {
        this.dao = new PositiveMatchDAO();
    }

    public static PositiveMatchService getInstance() {
        return INSTANCE;
    }

    public boolean create(String name){
        PositiveMatch positiveMatch = new PositiveMatch().withName(name);

        return dao.create(positiveMatch);
    }

    public Optional<PositiveMatch> read(int id) throws IllegalArgumentException{

        Optional<PositiveMatch> positiveMatchOptional = null;
        try {
            positiveMatchOptional = dao.read( new PositiveMatch().withId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positiveMatchOptional;
    }

    public Optional<PositiveMatch> read(String name) throws IllegalArgumentException{

        Optional<PositiveMatch> positiveMatchOptional = null;
        try {
            positiveMatchOptional = dao.read(new PositiveMatch().withName(name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positiveMatchOptional;
    }

    public Optional<List<PositiveMatch>> readAll(){
        return dao.readAll();
    }

    public boolean delete(String name){
        return dao.delete(new PositiveMatch().withName(name));
    }
}

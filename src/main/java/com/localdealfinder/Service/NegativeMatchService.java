package com.localdealfinder.Service;

import com.localdealfinder.database.NegativeMatchDAO;
import com.localdealfinder.model.NegativeMatch;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class NegativeMatchService {
    private static final NegativeMatchService INSTANCE = new NegativeMatchService();

    private NegativeMatchDAO dao;

    private NegativeMatchService() {
        this.dao = new NegativeMatchDAO();
    }

    public static NegativeMatchService getInstance() {
        return INSTANCE;
    }

    public boolean create(String name){
        NegativeMatch negativeMatch = new NegativeMatch().withName(name);

        return dao.create(negativeMatch);
    }

    public Optional<NegativeMatch> read(int id) throws IllegalArgumentException{

        Optional<NegativeMatch> negativeMatchOptional = null;
        try {
            negativeMatchOptional = dao.read( new NegativeMatch().withId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return negativeMatchOptional;
    }

    public Optional<NegativeMatch> read(String name) throws IllegalArgumentException{

        Optional<NegativeMatch> negativeMatchOptional = null;
        try {
            negativeMatchOptional = dao.read(new NegativeMatch().withName(name));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return negativeMatchOptional;
    }

    public Optional<List<NegativeMatch>> readAll(){
        return dao.readAll();
    }

    public boolean delete(String name){
        return dao.delete(new NegativeMatch().withName(name));
    }
}

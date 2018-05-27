package com.localdealfinder.Service;

import com.localdealfinder.database.UserAdvertJnDAO;
import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserAdvertService {
    private static final UserAdvertService INSTANCE = new UserAdvertService();

    private UserAdvertJnDAO dao;

    private UserAdvertService() {
        this.dao = new UserAdvertJnDAO();
    }

    public static UserAdvertService getInstance() {
        return INSTANCE;
    }


    public boolean create(int user_id, int advert_id){
        return dao.create(new User().withId(user_id), new Advert().withId(advert_id));
    }

    public Optional<List<Advert>> readAll(int user_id){

        Optional<List<Advert>> advertsOptional = null;
        try {
            advertsOptional = dao.readAll(new User().withId(user_id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advertsOptional;
    }

    public boolean delete(int user_id, int advert_id){
        return dao.delete(new User().withId(user_id),new Advert().withId(advert_id));
    }
}

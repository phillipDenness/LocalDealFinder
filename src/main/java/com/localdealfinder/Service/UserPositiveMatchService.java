package com.localdealfinder.Service;

import com.localdealfinder.database.UserPositiveMatchJnDAO;
import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserPositiveMatchService {
    private static final UserPositiveMatchService INSTANCE = new UserPositiveMatchService();

    private UserPositiveMatchJnDAO dao;

    private UserPositiveMatchService() {
        this.dao = new UserPositiveMatchJnDAO();
    }

    public static UserPositiveMatchService getInstance() {
        return INSTANCE;
    }


    public boolean create(int user_id, int positive_id){
        return dao.create(new User().withId(user_id), new PositiveMatch().withId(positive_id));
    }

    public User readAll(int user_id){

        Optional<List<PositiveMatch>> positiveMatches = null;
        User user = new User().withId(user_id);
        try {
            user = dao.readAll(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean delete(int user_id, int positive_id){
        return dao.delete(new User().withId(user_id),new PositiveMatch().withId(positive_id));
    }
}

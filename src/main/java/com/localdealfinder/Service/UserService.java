package com.localdealfinder.Service;

import com.localdealfinder.database.UserDAO;
import com.localdealfinder.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private UserDAO dao;

    private UserService() {
        this.dao = new UserDAO();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    public boolean create(String alias){
        User user = new User().withAlias(alias);

        return dao.create(user);
    }

    public Optional<User> read(int id) throws IllegalArgumentException{

        Optional<User> userOptional = null;
        try {
            userOptional = dao.read( new User().withId(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOptional;
    }

    public Optional<User> read(String alias) throws IllegalArgumentException{

        Optional<User> userOptional = null;
        try {
            userOptional = dao.read(new User().withAlias(alias));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOptional;
    }

    public Optional<List<User>> readAll(){
        Optional<List<User>> optionalUsers = null;
        try {
            optionalUsers = dao.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalUsers;
    }

    public boolean delete(String alias){
        return dao.delete(new User().withAlias(alias));
    }
}

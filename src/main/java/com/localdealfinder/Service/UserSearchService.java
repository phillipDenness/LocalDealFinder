package com.localdealfinder.Service;

import com.localdealfinder.database.UserSearchJnDAO;
import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;
import com.localdealfinder.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserSearchService {
    private static final UserSearchService INSTANCE = new UserSearchService();

    private UserSearchJnDAO dao;

    private UserSearchService() {
        this.dao = new UserSearchJnDAO();
    }

    public static UserSearchService getInstance() {
        return INSTANCE;
    }


    public boolean create(String alias, int search_id){
        return dao.create(new User().withAlias(alias), new Search().withId(search_id));
    }

    public User readAll(String alias){
        User user = new User().withAlias(alias);
        try {
            user = dao.readAll(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean delete(String alias, int search_id){
        return dao.delete(new User().withAlias(alias),new Search().withId(search_id));
    }
}

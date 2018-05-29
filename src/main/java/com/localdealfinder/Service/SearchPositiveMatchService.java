package com.localdealfinder.Service;

import com.localdealfinder.database.SearchPositiveMatchJnDAO;
import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;

import java.sql.SQLException;

public class SearchPositiveMatchService {
    private static final SearchPositiveMatchService INSTANCE = new SearchPositiveMatchService();

    private SearchPositiveMatchJnDAO dao;

    private SearchPositiveMatchService() {
        this.dao = new SearchPositiveMatchJnDAO();
    }

    public static SearchPositiveMatchService getInstance() {
        return INSTANCE;
    }


    public boolean create(int search_id, int positive_id){
        return dao.create(new Search().withId(search_id), new PositiveMatch().withId(positive_id));
    }

    public Search readAll(int search_id){
        Search search = new Search().withId(search_id);
        try {
            search = dao.readAll(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return search;
    }

    public boolean delete(int search_id, int positive_id){
        return dao.delete(new Search().withId(search_id),new PositiveMatch().withId(positive_id));
    }
}

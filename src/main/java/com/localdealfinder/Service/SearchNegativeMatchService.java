package com.localdealfinder.Service;

import com.localdealfinder.database.SearchNegativeMatchJnDAO;
import com.localdealfinder.model.NegativeMatch;
import com.localdealfinder.model.Search;

import java.sql.SQLException;

public class SearchNegativeMatchService {
    private static final SearchNegativeMatchService INSTANCE = new SearchNegativeMatchService();

    private SearchNegativeMatchJnDAO dao;

    private SearchNegativeMatchService() {
        this.dao = new SearchNegativeMatchJnDAO();
    }

    public static SearchNegativeMatchService getInstance() {
        return INSTANCE;
    }


    public boolean create(int search_id, int negative_id){
        return dao.create(new Search().withId(search_id), new NegativeMatch().withId(negative_id));
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

    public boolean delete(int search_id, int negative_id){
        return dao.delete(new Search().withId(search_id),new NegativeMatch().withId(negative_id));
    }
}

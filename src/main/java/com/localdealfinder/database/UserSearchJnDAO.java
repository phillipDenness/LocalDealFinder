package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;
import com.localdealfinder.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserSearchJnDAO {
    public User readAll(User user) throws SQLException {

        String sql = "SELECT user.user_id, alias, search.search_id, search.name, location, min_price, max_price" +
        " FROM ldf.user_search_jn" +
        " JOIN ldf.user on user.user_id = user_search_jn.user_id" +
        " JOIN ldf.search on search.search_id = user_search_jn.search_id" +
        " WHERE alias = ?";

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, user.getAlias());
            rs = pstmt.executeQuery();

            if(rs.next()){
                user.withId(rs.getInt("user_id"));
                rs.beforeFirst();
            }

            while(rs.next()){
                user.withSearch(new Search().withId(rs.getInt("search_id"))
                .withName(rs.getString("name"))
                .withLocation(rs.getString("location"))
                .withMinPrice(rs.getDouble("min_price"))
                .withMaxPrice(rs.getDouble("max_price")));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return user;
        }
    }


    public boolean create(User user, Search search){

        String sql = "INSERT INTO ldf.user_search_jn " +
                "values ((SELECT user_id FROM ldf.user WHERE alias = ?), ?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, user.getAlias());
            pstmt.setInt(2, search.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(User user, Search search) {

        String sql = " DELETE FROM ldf.user_search_jn" +
                " WHERE user_id = (select user_id from ldf.user where alias = ?)" +
                " AND search_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, user.getAlias());
            pstmt.setInt(2, search.getId());
            int affectedRows = pstmt.executeUpdate();
            user.withSearches(new ArrayList<>());
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

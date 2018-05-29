package com.localdealfinder.database;

import com.localdealfinder.model.NegativeMatch;
import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchNegativeMatchJnDAO {
    public Search readAll(Search search) throws SQLException {

        String sql = "SELECT search.search_id, search.name search_name, location, min_price, max_price, negative_match.negative_id, negative_match.name" +
                " from ldf.search_negative_match_jn snm" +
                " join ldf.search on snm.search_id = search.search_id" +
                " join ldf.negative_match on snm.negative_id = negative_match.negative_id" +
                " where ldf.snm.search_id = ?;";

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, search.getId());
            rs = pstmt.executeQuery();

            if(rs.next()){
                search.withId(rs.getInt(1));
                search.withName(rs.getString(2));
                search.withLocation(rs.getString(3));
                search.withMinPrice(rs.getDouble(4));
                search.withMaxPrice(rs.getDouble(5));
                rs.beforeFirst();
            }

            while(rs.next()){
                search.withNegativeMatch(new NegativeMatch().withId(rs.getInt(6))
                        .withName(rs.getString(7)));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return search;
        }
    }

    public boolean create(Search search, NegativeMatch negativeMatch){

        String sql = "INSERT INTO ldf.search_negative_match_jn(search_id, negative_id) " +
                " VALUES(?,?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, search.getId());
            pstmt.setInt(2, negativeMatch.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Search search, NegativeMatch negativeMatch) {

        String sql = "DELETE FROM ldf.search_negative_match_jn" +
                " WHERE search_id = ? AND negative_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, search.getId());
            pstmt.setInt(2, negativeMatch.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

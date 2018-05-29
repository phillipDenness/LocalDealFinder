package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.Search;
import com.localdealfinder.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchPositiveMatchJnDAO {
    public Search readAll(Search search) throws SQLException {

        String sql = "SELECT search.search_id, search.name, location, min_price, max_price, positive_match.positive_id, positive_match.name" +
                " from ldf.search_positive_match_jn spm" +
                " join ldf.search on spm.search_id = search.search_id" +
                " join ldf.positive_match on spm.positive_id = positive_match.positive_id" +
                " where ldf.spm.search_id = ?";

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, search.getId());
            System.out.println(pstmt);
            rs = pstmt.executeQuery();

            if(rs.next()){
                search.withId(rs.getInt(1));
                search.withLocation(rs.getString(2));
                search.withLocation(rs.getString(3));
                search.withMinPrice(rs.getDouble(4));
                search.withMaxPrice(rs.getDouble(5));
                rs.beforeFirst();
            }

            while(rs.next()){
                search.withPositiveMatch(new PositiveMatch().withId(rs.getInt("positive_id"))
                        .withName(rs.getString("name")));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return search;
        }
    }


    public boolean create(Search search, PositiveMatch positiveMatch){

        String sql = "INSERT INTO ldf.search_positive_match_jn(search_id, positive_id) " +
                " VALUES(?,?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, search.getId());
            pstmt.setInt(2, positiveMatch.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Search search, PositiveMatch positiveMatch) {

        String sql = "DELETE FROM ldf.search_positive_match_jn" +
                " WHERE search_id = ? AND positive_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, search.getId());
            pstmt.setInt(2, positiveMatch.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

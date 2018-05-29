package com.localdealfinder.database;

import com.localdealfinder.model.Search;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchDAO {
    public Optional<List<Search>> readAll() throws SQLException {
        String sql = "SELECT *" +
                " FROM ldf.search";

        List<Search> searches = null;
        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement()){

            rs = stmt.executeQuery(sql);

            if(rs.next()){
                searches = new ArrayList<>();
                rs.beforeFirst();
            }

            while(rs.next()){
                Search search = new Search().withId(rs.getInt(1))
                        .withName(rs.getString(2))
                        .withLocation(rs.getString(3))
                        .withMinPrice(rs.getDouble(4))
                        .withMaxPrice(rs.getDouble(5));
                searches.add(search);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return Optional.ofNullable(searches);
        }
    }

    public boolean create(Search search){

        String sql = "INSERT INTO ldf.search(name, location, min_price, max_price) " +
                " VALUES(?, ?, ?, ?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, search.getName());
            pstmt.setString(2, search.getLocation());
            pstmt.setDouble(3, search.getMinPrice());
            pstmt.setDouble(4, search.getMaxPrice());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Search search) {

        String sql = "DELETE FROM ldf.search" +
                " WHERE search_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, search.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<Search> read(Search search) throws SQLException, IllegalArgumentException {

        String sql = "SELECT * FROM ldf.search WHERE search_id = ?";

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, search.getId());

            rs = pstmt.executeQuery();

            while (rs.next()){
                search.withId(rs.getInt(1))
                    .withName(rs.getString(2))
                    .withLocation(rs.getString(3))
                    .withMinPrice(rs.getDouble(4))
                    .withMaxPrice(rs.getDouble(5));
            }
            return Optional.ofNullable(search);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            rs.close();
        }
    }
}

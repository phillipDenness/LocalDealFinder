package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.PositiveMatch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PositiveMatchDAO {

    public Optional<List<PositiveMatch>> readAll() {
        String sql = "SELECT *" +
                " FROM ldf.positive_match";

        List<PositiveMatch> positiveMatches = null;
        try(Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            if(rs.next()){
                positiveMatches = new ArrayList<>();
                rs.beforeFirst();
            }

            while(rs.next()){
                PositiveMatch positiveMatch = new PositiveMatch().withId(rs.getInt(1))
                        .withName(rs.getString(2));

                positiveMatches.add(positiveMatch);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            return Optional.ofNullable(positiveMatches);
        }
    }

    public boolean create(PositiveMatch positiveMatch){

        String sql = "INSERT INTO ldf.positive_match(name) " +
                " VALUES(?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, positiveMatch.getName());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(PositiveMatch positiveMatch) {

        String sql = "DELETE FROM ldf.positive_match" +
                " WHERE name = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, positiveMatch.getName());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<PositiveMatch> read(PositiveMatch positiveMatch) throws SQLException, IllegalArgumentException {
        String sql;
        boolean useId = false;
        if (positiveMatch.getId() != 0) {
            sql = "SELECT * FROM ldf.positive_match WHERE positive_id = ?";
            useId = true;
        } else if (positiveMatch.getName() != null)
            sql = "SELECT * FROM ldf.positive_match WHERE name = ?";
        else
            throw new IllegalArgumentException("Positive match object is missing mandatory parameters");

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (useId)
                pstmt.setInt(1, positiveMatch.getId());
            else
                pstmt.setString(1, positiveMatch.getName());

            rs = pstmt.executeQuery();

            while (rs.next()){
                positiveMatch.withId(rs.getInt(1));
                positiveMatch.withName(rs.getString(2));
            }

            return Optional.ofNullable(positiveMatch);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            rs.close();
        }
    }
}

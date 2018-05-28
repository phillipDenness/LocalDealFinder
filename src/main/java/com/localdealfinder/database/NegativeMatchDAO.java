package com.localdealfinder.database;

import com.localdealfinder.model.NegativeMatch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NegativeMatchDAO {

    public Optional<List<NegativeMatch>> readAll() {
        String sql = "SELECT *" +
                " FROM ldf.negative_match";

        List<NegativeMatch> negativeMatches = null;
        try(Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            if(rs.next()){
                negativeMatches = new ArrayList<>();
                rs.beforeFirst();
            }

            while(rs.next()){
                NegativeMatch negativeMatch = new NegativeMatch().withId(rs.getInt(1))
                        .withName(rs.getString(2));

                negativeMatches.add(negativeMatch);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            return Optional.ofNullable(negativeMatches);
        }
    }

    public boolean create(NegativeMatch negativeMatch){

        String sql = "INSERT INTO ldf.negative_match(name) " +
                " VALUES(?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, negativeMatch.getName());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(NegativeMatch negativeMatch) {

        String sql = "DELETE FROM ldf.negative_match" +
                " WHERE name = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, negativeMatch.getName());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<NegativeMatch> read(NegativeMatch negativeMatch) throws SQLException, IllegalArgumentException {
        String sql;
        boolean useId = false;
        if (negativeMatch.getId() != 0) {
            sql = "SELECT * FROM ldf.negative_match WHERE negative_id = ?";
            useId = true;
        } else if (negativeMatch.getName() != null)
            sql = "SELECT * FROM ldf.negative_match WHERE name = ?";
        else
            throw new IllegalArgumentException("Positive match object is missing mandatory parameters");

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (useId)
                pstmt.setInt(1, negativeMatch.getId());
            else
                pstmt.setString(1, negativeMatch.getName());

            rs = pstmt.executeQuery();

            while (rs.next()){
                negativeMatch.withId(rs.getInt(1));
                negativeMatch.withName(rs.getString(2));
            }

            return Optional.ofNullable(negativeMatch);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            rs.close();
        }
    }
}

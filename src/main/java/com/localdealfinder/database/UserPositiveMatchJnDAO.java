package com.localdealfinder.database;

import com.localdealfinder.model.PositiveMatch;
import com.localdealfinder.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPositiveMatchJnDAO {
    public User readAll(User user) throws SQLException {

        String sql = "SELECT user.user_id, alias, positive_match.positive_id, positive_match.name" +
                " FROM ldf.user_positive_match_jn" +
                " JOIN ldf.user on user_positive_match_jn.user_id = ldf.user.user_id" +
                " JOIN ldf.positive_match on user_positive_match_jn.positive_id = positive_match.positive_id" +
                " WHERE ldf.user.user_id = ?" ;

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, user.getId());
            System.out.println(pstmt);
            rs = pstmt.executeQuery();

            if(rs.next()){
                user.withAlias(rs.getString("user_id"));
                rs.beforeFirst();
            }

            while(rs.next()){
                user.withPositiveMatch(new PositiveMatch().withId(rs.getInt("positive_id"))
                        .withName(rs.getString("name")));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return user;
        }
    }


    public boolean create(User user, PositiveMatch positiveMatch){

        String sql = "INSERT INTO ldf.user_positive_match_jn(user_id, positive_id) " +
                " VALUES(?,?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, positiveMatch.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(User user, PositiveMatch positiveMatch) {

        String sql = "DELETE FROM ldf.user_positive_match_jn" +
                " WHERE user_id = ? AND positive_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, positiveMatch.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;

import java.sql.*;

public class UserAdvertJnDAO {

    public User readAll(User user) throws SQLException {
        String sql = "SELECT user.user_id, alias, advert.advert_id, advert_title, advert_price, advert_link" +
                    " FROM ldf.user_advert_jn" +
                    " JOIN ldf.user on user_advert_jn.user_id = ldf.user.user_id" +
                    " JOIN ldf.advert on user_advert_jn.advert_id = advert.advert_id" +
                    " WHERE user.user_id = ?" ;

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, user.getId());
            rs = pstmt.executeQuery();

            if(rs.next()){
                user.withAlias(rs.getString("user_id"));
                rs.beforeFirst();
            }

            while(rs.next()){
                user.withAdvert(new Advert().withId(rs.getInt("advert_id"))
                        .withTitle(rs.getString("advert_title"))
                        .withPrice(rs.getDouble("advert_price"))
                        .withLink(rs.getString("advert_link")));
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return user;
        }
    }


    public boolean create(User user, Advert advert){

        String sql = "INSERT INTO ldf.user_advert_jn(user_id, advert_id) " +
                " VALUES(?,?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, advert.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(User user, Advert advert) {

        String sql = "DELETE FROM ldf.user_advert_jn" +
                " WHERE user_id = ? AND advert_id = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, user.getId());
            pstmt.setInt(2, advert.getId());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

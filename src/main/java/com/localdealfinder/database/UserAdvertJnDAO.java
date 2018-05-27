package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserAdvertJnDAO {

    public Optional<List<Advert>> readAll(User user) throws SQLException {
        String sql = "SELECT *" +
                " FROM ldf.user_advert_jn" +
                " WHERE user_id = ?";

        List<Advert> adverts = null;
        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setInt(1, user.getId());
            rs = pstmt.executeQuery();

            if(rs.next()){
                adverts = new ArrayList<>();
                rs.beforeFirst();
            }

            while(rs.next()){
                AdvertDAO advertDAO = new AdvertDAO();

                Advert advert = new Advert().withId(rs.getInt("advert_id"));
                Optional<Advert> advertOptional = advertDAO.read(advert);

                if(advertOptional.isPresent())
                    adverts.add(advertOptional.get());
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return Optional.ofNullable(adverts);
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

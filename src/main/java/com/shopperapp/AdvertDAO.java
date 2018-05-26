package com.shopperapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdvertDAO {

    public Optional<List<Advert>> readAll() throws SQLException {
        String sql = "SELECT *" +
                " FROM shopper.advert";

        List<Advert> adverts = null;
        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            rs = pstmt.executeQuery();

            if(rs.next()){
                adverts = new ArrayList<>();
                rs.beforeFirst();
            }

            while(rs.next()){
                Advert advert = new Advert().withId(rs.getInt(1))
                        .withTitle(rs.getString(2))
                        .withPrice(rs.getInt(3))
                        .withLink(rs.getString(4));
                adverts.add(advert);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return Optional.ofNullable(adverts);
        }
    }
}

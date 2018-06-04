package com.localdealfinder.database;

import com.localdealfinder.model.Advert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdvertDAO {

    public Optional<List<Advert>> readAll() throws SQLException {
        String sql = "SELECT *" +
                " FROM ldf.advert";

        List<Advert> adverts = null;
        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement()){

            rs = stmt.executeQuery(sql);

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
            rs.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            return Optional.ofNullable(adverts);
        }
    }


    public boolean create(Advert advert){

        String sql = "INSERT INTO ldf.advert(advert_title, advert_price, advert_link) " +
                " VALUES(?,?,?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, advert.getTitle());
            pstmt.setDouble(2, advert.getPrice());
            pstmt.setString(3, advert.getLink());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Advert advert) {

        String sql = "DELETE FROM ldf.advert" +
                " WHERE advert_link = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, advert.getLink());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<Advert> read(Advert advert) throws SQLException, IllegalArgumentException {
        String sql;
        boolean useId = false;
        if (advert.getId() != 0) {
            sql = "SELECT * FROM ldf.advert WHERE advert_id = ?";
            useId = true;
        } else if (advert.getLink() != null)
            sql = "SELECT * FROM ldf.advert WHERE advert_link = ?";
        else
            throw new IllegalArgumentException("Advert object is missing mandatory parameters");

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (useId)
                pstmt.setInt(1, advert.getId());
            else
                pstmt.setString(1, advert.getLink());

            rs = pstmt.executeQuery();

            while (rs.next()){
                advert.withId(rs.getInt(1));
                advert.withTitle(rs.getString(2));
                advert.withPrice(rs.getDouble(3));
                advert.withLink(rs.getString(4));
            }

            return Optional.ofNullable(advert);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            rs.close();
        }
    }
}

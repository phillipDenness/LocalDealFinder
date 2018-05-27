package com.localdealfinder.database;

import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    public Optional<List<User>> readAll() throws SQLException {
        String sql = "SELECT *" +
                " FROM ldf.user";

        List<User> users = null;
        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement()){

            rs = stmt.executeQuery(sql);

            if(rs.next()){
                users = new ArrayList<>();
                rs.beforeFirst();
            }

            while(rs.next()){
                User user = new User().withId(rs.getInt(1))
                        .withAlias(rs.getString(2));
                users.add(user);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            return Optional.ofNullable(users);
        }
    }


    public boolean create(User user){

        String sql = "INSERT INTO ldf.user(alias) " +
                " VALUES(?)";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){

            pstmt.setString(1, user.getAlias());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(User user) {

        String sql = "DELETE FROM ldf.user" +
                " WHERE alias = ?";

        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, user.getAlias());
            int affectedRows = pstmt.executeUpdate();
            return (affectedRows == 1);

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Optional<User> read(User user) throws SQLException, IllegalArgumentException {
        String sql;
        boolean useId = false;
        if (user.getId() != 0) {
            sql = "SELECT * FROM ldf.user WHERE user_id = ?";
            useId = true;
        } else if (user.getAlias() != null)
            sql = "SELECT * FROM ldf.user WHERE alias = ?";
        else
            throw new IllegalArgumentException("Advert object is missing mandatory parameters");

        ResultSet rs = null;
        try(Connection con = ConnectionManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (useId)
                pstmt.setInt(1, user.getId());
            else
                pstmt.setString(1, user.getAlias());

            rs = pstmt.executeQuery();

            while (rs.next()){
                user.withId(rs.getInt(1));
                user.withAlias(rs.getString(2));
            }

            return Optional.ofNullable(user);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            rs.close();
        }
    }
}

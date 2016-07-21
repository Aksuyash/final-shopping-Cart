/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CsuEastBay.Util;

import CsuEastBay.model.Address;
import CsuEastBay.bean.UserAccount;
import CsuEastBay.model.Item;
import CsuEastBay.model.User;
import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class DataBase implements Serializable{
    
    private static Connection getConnection()
    {
        Connection connection = null;
        try {
            String dbURL = "jdbc:mysql://localhost:3306/lenden";
            String username = "root";
            String password = "Coder12";
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection(
            dbURL, username, password);
        } catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
        return connection;
    }
    
    
    public static User SelectUser(String id)
    {
        User user = null;
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM USER_TABLE "
                + "WHERE userId = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setUserId(rs.getString("userId"));
                user.setMiddleName(rs.getString("middleName"));
            }
            ps.executeUpdate();
            ps.close();
            rs.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
        return user;
    }
    
    
    
    public static ArrayList<Item> SelectItem(double id)
    {
        ArrayList<Item>  arrayitem = null;
        
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM ITEM_TABLE";
            //ps = connection.prepareStatement(query);
            //ps.setDouble(1, id);
            System.out.println("asdfadsfas     ");

            rs = statement.executeQuery(query);
            if (rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                double in = (rs.getDouble("id"));
                item.setId((int) in);
                item.setId((int)id);
                System.out.println(item.getDescription());
                arrayitem.add(item);
            }
            ps.executeUpdate();
            ps.close();
            rs.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
        return arrayitem;
    }
    
    
    public static void UpdateItem(Item item)
    {
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            String query = "UPDATE ITEM_TABLE SET "
                + " name = ?"
                + "description = ? "
                + "price = ? "
                + "date = ?"
                + "id = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getDate());
            ps.setDouble(5, item.getId());
            ps.executeUpdate();
            ps.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
    }
    
    
    public static void UpdateUser(User user)
    {
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            String query = "UPDATE USER_TABLE SET "
                + "firstName = ? "
                + "middleName = ? "
                + "lastName = ?"
                + "email = ?"
                + "userId = ?"
                + "password = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getMiddleName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getUserId());
            ps.setString(6, user.getPassword());
            ps.executeUpdate();
            ps.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
    }
    
    public static void InsertUser(User user)
    {
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            String query = "INSERT INTO USER_TABLE (firstName, middleName, lastName, email, userId, password)"
                + "VALUES(?,?,?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getMiddleName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getUserId());
            ps.setString(6, user.getPassword());
            ps.executeUpdate();
            ps.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
    }
    
    
    public static void InsertItem(Item item)
    {
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            String query = "INSERT INTO ITEM_TABLE (name,description,price,date,id)"
                + "VALUES (?,?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getDate());
            ps.setDouble(5, item.getId());
            ps.executeUpdate();
            ps.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
    }
    
    public static void DeleteUser(User user)
    {
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            String query = "DELETE FROM USER_TABLE "
                    + "WHERE userId = ?";
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserId());
            ps.executeUpdate();
            ps.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
    } 


    public static void DeleteItem(Item item)
    {
        try{
            Connection connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement ps = null;
            String query = "DELETE FROM ITEM_TABLE "
                    + "WHERE id = ?";
            ps = connection.prepareStatement(query);
            ps.setLong(1, item.getId());
            ps.executeUpdate();
            ps.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            for (Throwable t : e)
                 t.printStackTrace();
        }
    }     
}
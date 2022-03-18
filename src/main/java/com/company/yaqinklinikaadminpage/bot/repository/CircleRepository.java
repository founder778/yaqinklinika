package com.company.yaqinklinikaadminpage.bot.repository;

import com.company.yaqinklinikaadminpage.bot.entity.Button;
import com.company.yaqinklinikaadminpage.bot.entity.District;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CircleRepository {
    static String url = "jdbc:postgresql://localhost:5432/yaqinklinikadb";
    static String username = "postgres";
    static String pas = "111_Google_777";
    static Connection connection;

    public static List<String> retunCircleType() {
        List<String> diagnostik = new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select a_type from circle where lan = 'UZ' group by(a_type)";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                diagnostik.add(resultSet.getString("a_type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnostik;
    }
    public static List<String> retunCircleTypeRu() {
        List<String> diagnostik = new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select a_type from circle where lan = 'RU' group by(a_type)";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                diagnostik.add(resultSet.getString("a_type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnostik;
    }


    public static List<Button> retunCircleByType(String data) {
        List<Button> analiz = new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select distinct a_name from circle where a_type = '" + data + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Button button = new Button();
                button.setName(resultSet.getString("a_name").toUpperCase());
                button.setData(resultSet.getString("a_name").toLowerCase());
                analiz.add(button);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return analiz;
    }

    public static Integer retunCircleByName(String data) {
        Integer ans = 0;
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select d_name from circle where a_name = '" + data + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ans  = resultSet.getInt("a_id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
    public static Integer retuntumanById(String data) {
        Integer ans = 0;
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select * from district where d_id = '" + data + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ans  = resultSet.getInt("a_id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ans;
    }
    public static List<District> retunDistByAnaliz(String analiz){
        List<District> districts =new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url,username,pas);
            String sql = "select * from district ";
            sql+=  "where d_id in (select c_d_id from clinc where c_id in (select  a_c_id from circle where a_name = '" + analiz +"'" + "))";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                District district = new District();
                district.setD_id(resultSet.getInt("d_id"));
                district.setName(resultSet.getString("d_name"));
                districts.add(district);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return districts;
    }
}

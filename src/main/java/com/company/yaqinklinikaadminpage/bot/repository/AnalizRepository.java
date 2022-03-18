package com.company.yaqinklinikaadminpage.bot.repository;


import com.company.yaqinklinikaadminpage.bot.entity.Button;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AnalizRepository {
    static String url = "jdbc:postgresql://localhost:5432/yaqinklinikadb";
    static String username = "postgres";
    static String pas = "111_Google_777";
    static Connection connection;

    public static List<String> retunAnalizType() {
        List<String> analiz = new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select a_type from analiz where lan = 'UZ' group by(a_type) ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                analiz.add(resultSet.getString("a_type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return analiz;
    }
    public static List<String> retunAnalizTypeRU() {
        List<String> analiz = new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select a_type from analiz where lan = 'RU' group by(a_type) ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                analiz.add(resultSet.getString("a_type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return analiz;
    }


    public static List<Button> retunAnalizByType(String data) {
        List<Button> analiz = new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url, username, pas);
            String sql = "select distinct a_name from analiz  where a_type = '" + data.toLowerCase() + "'";
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

}

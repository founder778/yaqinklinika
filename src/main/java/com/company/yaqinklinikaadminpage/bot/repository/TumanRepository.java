package com.company.yaqinklinikaadminpage.bot.repository;


import com.company.yaqinklinikaadminpage.bot.entity.District;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TumanRepository {
    static String url = "jdbc:postgresql://localhost:5432/yaqinklinikadb";
    static String username = "postgres";
    static String pas = "111_Google_777";
    static Connection connection;
    public static List<District> retunDistByAnaliz(String analiz , String table){
        List<District> districts =new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url,username,pas);
            String sql = "select * from district ";
                  sql+=  "where d_id in (select c_d_id from clinc where c_id in (select  a_c_id from ";
                  sql+= table + " where a_name = '" + analiz +"'" + "))";
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

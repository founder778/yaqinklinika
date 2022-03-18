package com.company.yaqinklinikaadminpage.bot.repository;

import com.company.yaqinklinikaadminpage.bot.entity.Clinic;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClincRepository {
    static String url = "jdbc:postgresql://localhost:5432/yaqinklinikadb";
    static String username = "postgres";
    static String pas = "111_Google_777";
    static Connection connection;
    public static List<String> retunClincByDistr(String district){
        List<String> clincs =new LinkedList<>();
        try {
            connection = DriverManager.getConnection(url,username,pas);
            String sql = "select c_name from clinc";
            sql+=  " where c_d_id in (select d_id from district where d_name = '" + district + "'"  + ")";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                clincs.add(resultSet.getString("c_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clincs;
    }
    public static Clinic retunClinc(String name){
        Clinic clinic = new Clinic();
        try {
            connection = DriverManager.getConnection(url,username,pas);
            String sql = "select * from clinc";
            sql+=  " where c_name = '" + name.toLowerCase() + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                clinic.setName(resultSet.getString("c_name"));
                clinic.setPhone(resultSet.getString("c_phone"));
                clinic.setAddress(resultSet.getString("c_address"));
                clinic.setC_arentr(resultSet.getString("c_arentr"));
                clinic.setC_Reyting(resultSet.getInt("c_reyting"));
                clinic.setC_karta(resultSet.getString("c_karta"));
                clinic.setTime(resultSet.getString("c_time"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clinic;
    }
}

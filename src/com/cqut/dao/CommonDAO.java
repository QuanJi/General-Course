package com.cqut.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommonDAO {
    private static CommonDAO commonDAO;

    public static CommonDAO getCommonDAO(){
        if(commonDAO == null){
            commonDAO = new CommonDAO();
        }
        return commonDAO;
    }

    public static Connection getConnection() throws Exception {
        String driverName = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/general_course";

        String userName = "root";

        String userPWD = "hero..22";

        Class.forName(driverName);

        Connection connection = DriverManager.getConnection(url, userName, userPWD);

        return connection;
    }

}

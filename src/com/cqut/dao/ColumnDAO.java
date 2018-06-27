package com.cqut.dao;

import com.cqut.entity.columnManage.ColumnTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/*
栏目管理
 */
public class ColumnDAO {

    public static List<ColumnTable> getCloumn(String sql)throws Exception{
        List<ColumnTable> list = new ArrayList<ColumnTable>();

        Connection connection = CommonDAO.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            ColumnTable columnTable = new ColumnTable();
            columnTable.setId(resultSet.getInt(1));
            columnTable.setColumnName(resultSet.getString(2));
            columnTable.setParentId(resultSet.getInt(3));
            //columnTable.setCount(resultSet.getInt(4));
            list.add(columnTable);
        }
        return list;

    }

    //得到符合条件栏目数
    public static Integer getTotal(String sql) throws Exception{
        Connection connection = CommonDAO.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        int SUM = 0 ;
        while(resultSet.next()) {
            SUM = resultSet.getInt(1);
        }
        connection.close();
        return SUM;
    }


}

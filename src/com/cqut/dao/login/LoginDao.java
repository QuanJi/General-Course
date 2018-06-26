package com.cqut.dao.login;

import com.cqut.dao.CommonDAO;
import com.cqut.entity.codeManage.CodeTable;
import com.cqut.entity.login.Operator;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginDao {

    private static LoginDao loginDao;

    public static LoginDao getLoginDao(){
        if(loginDao == null){
            loginDao = new LoginDao();
        }
        return loginDao;
    }

    //
    public List<Operator> getOperator(String sql) throws Exception {
        System.out.println(sql);

        List<Operator> list = new ArrayList<Operator>();

        Connection connection = CommonDAO.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Operator operator = new Operator();
            operator.setId(resultSet.getInt(1));
            operator.setName(resultSet.getString(2));
            operator.setPassword(resultSet.getNString(3));
            operator.setPrivilegeLevle(resultSet.getInt(4));

            list.add(operator);
        }
        return list;
    }


    //获得权限模块编号
    public List<Integer> getPermissionNum(String sql) throws Exception{
        List<Integer> list = new ArrayList<Integer>();

        Connection connection = CommonDAO.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            list.add(resultSet.getInt(1));
        }
        return list;
    }

    public static List<CodeTable> getModular(String sql) throws Exception{

        List<CodeTable> list = new ArrayList<CodeTable>();

        Connection connection = CommonDAO.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            CodeTable codeTable = new CodeTable();
            codeTable.setId(resultSet.getInt(1));
            codeTable.setCodeName(resultSet.getNString(2));
            codeTable.setLevel(resultSet.getInt(3));
            codeTable.setParent_id(resultSet.getInt(4));
            codeTable.setUrl(resultSet.getNString(5));
            list.add(codeTable);
        }
        return list;
    }
}

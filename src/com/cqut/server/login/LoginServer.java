package com.cqut.server.login;

import com.cqut.dao.login.LoginDao;
import com.cqut.entity.codeManage.CodeTable;
import com.cqut.entity.login.Operator;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class LoginServer {
    public static String checkAccount(String[] info) throws Exception {
        String userName = info[0];
        String password = info[1];

        String sql = "select id, name, password, privilege_level from operator ";
              sql += "where name='"+userName+"' and password='"+password+"'";

        List<Operator> list = LoginDao.getLoginDao().getOperator(sql);

        if(list.size() !=0){
            return list.get(0).getId()+"";
        }else{
            return false+"";
        }


        //得到Id值,去获得其能访问的模块
       /* Integer idNum = list.get(0).getId();


        System.out.println("管理员的编号："+idNum);*/

        //return true;
       /* return getPermissions(idNum);*/
    }

    public static JSONArray getPermissions(Integer id) throws Exception{

        String sql = "select c_p_id from permissions_table ";
              sql += "where o_p_id="+id;
        System.out.println(sql);
        List<Integer> list = LoginDao.getLoginDao().getPermissionNum(sql);

        List<CodeTable> tempList = new ArrayList<CodeTable>();
        for(int i=0; i<list.size(); i++){
            String otherSql = "select id, code_name, level, parent_id, url from code_table ";
                  otherSql += "where id="+list.get(i);
            System.out.println(otherSql);

            //查询模块名
            tempList.add(LoginDao.getModular(otherSql).get(0));
        }

        //对tempList结果进行处理
        List<CodeTable> rsList = new ArrayList<CodeTable>();
        for(int i=0 ; i<tempList.size() ; i++){
            System.out.println(tempList.get(i).getCodeName()+" "+tempList.get(i).getParent_id()+" "+tempList.get(i).getUrl());
            if(tempList.get(i).getParent_id() == 0){
                rsList.add(tempList.get(i));
            }
        }

        int[] howMany = new int[rsList.size()];
        for(int i=0 ; i<tempList.size() ; i++){

            for(int j=0 ; j<rsList.size() ; j++){
                if(tempList.get(i).getParent_id() == rsList.get(j).getId()){
                    howMany[j]++;
                }
            }
        }
        for(int z = 0 ; z<rsList.size() ; z++){
            CodeTable[] child = new CodeTable[howMany[z]];
            int yesNum = 0;
            for(int k = 0 ; k<tempList.size() ; k++){
                if(tempList.get(k).getParent_id() == rsList.get(z).getId()){
                    child[yesNum] = tempList.get(k);
                    yesNum++;
                }
            }
            rsList.get(z).setCodeTables(child);
        }

        //转换为json
        JSONArray json = JSONArray.fromObject(rsList);

        return json;
    }


}

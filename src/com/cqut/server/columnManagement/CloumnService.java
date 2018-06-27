package com.cqut.server.columnManagement;

import com.cqut.dao.ColumnDAO;
import com.cqut.entity.columnManage.ColumnTable;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class CloumnService {

    public static JSONArray getIt(String searchKey,Integer pageNum,Integer parentId) throws Exception{
        String sql = "";
        if(parentId == 0){
            sql += "select id ,column_name, parent_id from `column` where parent_id is null ";
            sql += " and column_name like '"+searchKey+"%'  ";
            sql += "limit 0,10";
            //System.out.println("查询："+sql);
        } else {
            sql += "select id ,column_name, parent_id from `column` where parent_id ="+parentId;
            //sql += "  and column_name ";
            //System.out.println("子查询："+sql);
        }

        JSONArray json =JSONArray.fromObject(ColumnDAO.getCloumn(sql)) ;

        return json;

    }

    public static JSONArray getColumnInfo()throws Exception{
        String sql = "select id, column_name, parent_id from `column`";

        List<ColumnTable> list = ColumnDAO.getCloumn(sql);

        //处理数据
        List<ColumnTable> otherList = new ArrayList<>();
        for(ColumnTable columnTable : list){
            if(columnTable.getParentId() == 0){
                otherList.add(columnTable);
            }
        }
        int[] howNum = new int[otherList.size()];
        for(int i=0 ; i < list.size() ; i++){
            for(int j=0 ; j < otherList.size() ; j++){
                if(list.get(i).getParentId() == otherList.get(j).getId()){
                    howNum[j]++;
                }
            }
        }
        for(int z=0 ; z < otherList.size() ; z++){
            ColumnTable[] child = new ColumnTable[howNum[z]];
            int yesNum = 0;
            for(int k=0 ; k < list.size() ; k++){
                if(otherList.get(z).getId() == list.get(k).getParentId()){
                    child[yesNum] = list.get(k);
                    yesNum ++;
                }
            }
            otherList.get(z).setChild(child);
        }

        //转换为json
        return JSONArray.fromObject(otherList);
    }

    //按条件得到数据条数
    public static Integer getAllDataWithCondition(String key,Integer parentId) throws Exception{
        String sql = "";
        if(parentId == 0){
            sql = "select count(*) from `column` where column_name like '"+key+"%' and parent_id is null";
        }else {
            sql = "select count(*) from `column` where column_name like '"+key+"%' and parent_id="+parentId;
        }
        System.out.println("数量"+sql);
        return ColumnDAO.getTotal(sql);
    }

    //按id进行删除
    public static void delIt(int[] id) {
        for(int i=0;i<id.length;i++){
            String sql = "delete from `column` where id ="+id[i];
            try {
                ColumnDAO.deleteData(sql);
               // Question.delete(sql);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

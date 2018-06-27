package com.cqut.server.columnManagement;

import com.cqut.dao.ColumnDAO;
import com.cqut.entity.columnManage.ColumnTable;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class CloumnService {

    public static JSONArray getColumnInfo()throws Exception{
        String sql = "select id, column_name, parent_id from column";

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
}

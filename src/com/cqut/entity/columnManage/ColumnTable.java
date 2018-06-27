package com.cqut.entity.columnManage;

public class ColumnTable {

    private Integer id;

    private String columnName;

    private Integer parentId;

    private ColumnTable[] child;

    public ColumnTable(){}

    ColumnTable(Integer id , String columnName , Integer parentId , ColumnTable[] child){
        this.id = id;
        this.columnName = columnName;
        this.parentId = parentId;
        this.child = child;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public ColumnTable[] getChild() {
        return child;
    }

    public void setChild(ColumnTable[] child) {
        this.child = child;
    }
}

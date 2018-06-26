package com.cqut.entity.codeManage;

import java.util.List;

public class CodeTable {

    private Integer id;

    private String CodeName;

    private Integer level;

    private Integer parent_id;

    private String url;

    private CodeTable[] children;

    public CodeTable(){};

    CodeTable(Integer id, String CodeName, Integer level, Integer parent_id, String url, CodeTable[] list){
        this.id = id;
        this.CodeName = CodeName;
        this.level = level;
        this.parent_id = parent_id;
        this.url = url;
        this.children =list;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeName() {
        return CodeName;
    }

    public void setCodeName(String codeName) {
        CodeName = codeName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public CodeTable[] getCodeTables() {
        return children;
    }

    public void setCodeTables(CodeTable[] list) {
        this.children = list;
    }
}

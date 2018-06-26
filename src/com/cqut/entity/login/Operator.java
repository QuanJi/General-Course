package com.cqut.entity.login;

public class Operator {
    private  Integer id ;

    private String  name;

    private String password ;

    private Integer privilegeLevle; //等级

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrivilegeLevle() {
        return privilegeLevle;
    }

    public void setPrivilegeLevle(Integer privilegeLevle) {
        this.privilegeLevle = privilegeLevle;
    }


    public Operator(){};

    Operator(Integer id, String name, String password, Integer privilegeLevle){
        this.id = id;
        this.name = name;
        this.password = password;
        this.privilegeLevle = privilegeLevle;
    }


}

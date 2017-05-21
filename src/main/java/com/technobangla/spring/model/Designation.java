package com.technobangla.spring.model;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public class Designation {

    private int id;
    private String code;
    private String name;

    public Designation() {
    }

    public Designation(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

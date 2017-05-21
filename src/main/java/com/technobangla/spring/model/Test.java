package com.technobangla.spring.model;

/**
 * Created by Ayakuth Pathan on 12-May-17.
 */
public class Test {
    private int id;
    private String name;

    public Test() {
    }

    public Test( String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

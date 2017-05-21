package com.technobangla.spring.model;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public class LeadSteps {
    private int id;
    private String name;
    private String slNo;

    public LeadSteps() {
    }

    public LeadSteps(String name, String slNo) {
        this.name = name;
        this.slNo = slNo;
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

    public String getSlNo() {
        return slNo;
    }

    public void setSlNo(String slNo) {
        this.slNo = slNo;
    }
}

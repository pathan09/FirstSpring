package com.technobangla.spring.model;

import java.util.Date;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public class Company {

    private int id;
    private String code;
    private String name;
    private String email;
    private String webAddress;
    private String phone;
    private String establishDate;
    private int organizationType;
    private int organizationIndustry;

    public Company() {
    }

    public Company(String code, String name, String email, String webAddress, String phone,
                   String establishDate, int organizationType, int organizationIndustry) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.webAddress = webAddress;
        this.phone = phone;
        this.establishDate = establishDate;
        this.organizationType = organizationType;
        this.organizationIndustry = organizationIndustry;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public int getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(int organizationType) {
        this.organizationType = organizationType;
    }

    public int getOrganizationIndustry() {
        return organizationIndustry;
    }

    public void setOrganizationIndustry(int organizationIndustry) {
        this.organizationIndustry = organizationIndustry;
    }
}

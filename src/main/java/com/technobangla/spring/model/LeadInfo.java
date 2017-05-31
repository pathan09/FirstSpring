package com.technobangla.spring.model;

/**
 * Created by Ayakuth Pathan on 31-May-17.
 */
public class LeadInfo {

    private int id;
    private String leadName;
    private String leadDescription;
    private String initiateDate;
    private int initiateEmployeeId;

    public LeadInfo() {
    }

    public LeadInfo(String leadName, String leadDescription, String initiateDate, int initiateEmployeeId) {
        this.leadName = leadName;
        this.leadDescription = leadDescription;
        this.initiateDate = initiateDate;
        this.initiateEmployeeId = initiateEmployeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadDescription() {
        return leadDescription;
    }

    public void setLeadDescription(String leadDescription) {
        this.leadDescription = leadDescription;
    }

    public String getInitiateDate() {
        return initiateDate;
    }

    public void setInitiateDate(String initiateDate) {
        this.initiateDate = initiateDate;
    }

    public int getInitiateEmployeeId() {
        return initiateEmployeeId;
    }

    public void setInitiateEmployeeId(int initiateEmployeeId) {
        this.initiateEmployeeId = initiateEmployeeId;
    }
}

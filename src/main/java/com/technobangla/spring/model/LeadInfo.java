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
    private String latitude;
    private String longitude;

    public LeadInfo() {
    }

    public LeadInfo(String leadName, String leadDescription, String initiateDate, int initiateEmployeeId,
                    String latitude, String longitude) {
        this.leadName = leadName;
        this.leadDescription = leadDescription;
        this.initiateDate = initiateDate;
        this.initiateEmployeeId = initiateEmployeeId;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

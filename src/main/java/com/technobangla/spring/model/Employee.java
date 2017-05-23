package com.technobangla.spring.model;

/**
 * Created by Ayakuth Pathan on 23-May-17.
 */
public class Employee {

    private int id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private int designationId;
    private int departmentId;
    private int companyId;
    private String phone;
    private String email;

    public Employee() {
    }

    public Employee( String employeeId, String firstName, String lastName, int designationId, int departmentId, int companyId, String phone, String email) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.designationId = designationId;
        this.departmentId = departmentId;
        this.companyId = companyId;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDesignationId() {
        return designationId;
    }

    public void setDesignationId(int designationId) {
        this.designationId = designationId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

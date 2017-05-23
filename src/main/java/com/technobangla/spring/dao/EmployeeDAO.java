package com.technobangla.spring.dao;

import com.technobangla.spring.model.Employee;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 23-May-17.
 */
public interface EmployeeDAO {

    public void saveOrUpdate(Employee employee);

    public void delete(int id);

    public Employee get(int id);

    public List<Employee> list();
}

package com.technobangla.spring.dao;

import com.technobangla.spring.model.Department;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface DepartmentDAO {

    public void saveOrUpdate(Department department);

    public void delete(int id);

    public Department get(int id);

    public List<Department> list();
}

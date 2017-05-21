package com.technobangla.spring.dao;


import com.technobangla.spring.model.Designation;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface DesignationDAO {

    public void saveOrUpdate(Designation designation);

    public void delete(int id);

    public Designation get(int id);

    public List<Designation> list();
}

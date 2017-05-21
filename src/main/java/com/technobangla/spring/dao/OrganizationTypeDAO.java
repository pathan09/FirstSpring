package com.technobangla.spring.dao;

import com.technobangla.spring.model.OrganizationType;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface OrganizationTypeDAO {

    public void saveOrUpdate(OrganizationType test);

    public void delete(int id);

    public OrganizationType get(int id);

    public List<OrganizationType> list();
}

package com.technobangla.spring.dao;

import com.technobangla.spring.model.OrganizationIndustry;


import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface OrganizationIndustryDAO {

    public void saveOrUpdate(OrganizationIndustry test);

    public void delete(int id);

    public OrganizationIndustry get(int id);

    public List<OrganizationIndustry> list();
}

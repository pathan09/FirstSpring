package com.technobangla.spring.dao;


import com.technobangla.spring.model.Company;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface CompanyDAO {

    public void saveOrUpdate(Company company);

    public void delete(int id);

    public Company get(int id);

    public List<Company> list();
}

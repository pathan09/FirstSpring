package com.technobangla.spring.dao;

import com.technobangla.spring.model.AccountContact;
import com.technobangla.spring.model.Employee;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 23-May-17.
 */
public interface AccountContactDAO {

    public void saveOrUpdate(AccountContact accountContact);

    public void delete(int id);

    public AccountContact get(int id);

    public List<AccountContact> list();
}

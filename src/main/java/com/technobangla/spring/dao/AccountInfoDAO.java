package com.technobangla.spring.dao;


import com.technobangla.spring.model.AccountInfo;
import com.technobangla.spring.model.Company;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface AccountInfoDAO {

    public void saveOrUpdate(AccountInfo accountInfo);

    public void delete(int id);

    public AccountInfo get(int id);

    public List<AccountInfo> list();
}

package com.technobangla.spring.dao;

import com.technobangla.spring.model.Test;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 12-May-17.
 */
public interface TestDAO {

    public void saveOrUpdate(Test test);

    public void delete(int id);

    public Test get(int id);

    public List<Test> list();
}

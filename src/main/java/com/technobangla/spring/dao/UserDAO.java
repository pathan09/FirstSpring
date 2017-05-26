package com.technobangla.spring.dao;

import com.technobangla.spring.model.Department;
import com.technobangla.spring.model.User;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface UserDAO {

    public void saveOrUpdate(User user);

    public void delete(int id);

    public User get(int id);

    public List<User> list();
}

package com.technobangla.spring.dao;


import com.technobangla.spring.model.LeadSteps;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface LeadStepsDAO {

    public void saveOrUpdate(LeadSteps leadSteps);

    public void delete(int id);

    public LeadSteps get(int id);

    public List<LeadSteps> list();
}

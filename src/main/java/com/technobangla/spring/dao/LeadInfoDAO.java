package com.technobangla.spring.dao;

import com.technobangla.spring.model.LeadInfo;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */
public interface LeadInfoDAO {

    public void saveOrUpdate(LeadInfo leadInfo);

    public void delete(int id);

    public LeadInfo get(int id);

    public List<LeadInfo> list();
}

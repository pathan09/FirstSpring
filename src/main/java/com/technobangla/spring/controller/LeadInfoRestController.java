package com.technobangla.spring.controller;

import com.technobangla.spring.dao.EmployeeDAO;
import com.technobangla.spring.dao.LeadInfoDAO;
import com.technobangla.spring.model.LeadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ayakuth Pathan on 11-Jun-17.
 */

@RestController
@RequestMapping("/leadInfo")
public class LeadInfoRestController {

    @Autowired
    private LeadInfoDAO leadInfoDAO;


    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List list() {
        List<LeadInfo> leadInfoList = leadInfoDAO.list();

        return leadInfoList;
    }

   @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody LeadInfo leadInfo) {

       leadInfoDAO.saveOrUpdate(leadInfo);
       return new ResponseEntity(leadInfo, HttpStatus.OK);
    }


}

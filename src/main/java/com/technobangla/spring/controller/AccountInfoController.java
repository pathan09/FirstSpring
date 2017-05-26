package com.technobangla.spring.controller;

import com.technobangla.spring.dao.AccountInfoDAO;
import com.technobangla.spring.dao.CompanyDAO;
import com.technobangla.spring.dao.OrganizationIndustryDAO;
import com.technobangla.spring.dao.OrganizationTypeDAO;
import com.technobangla.spring.model.AccountInfo;
import com.technobangla.spring.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */

@Controller
@RequestMapping("/accountInfo")
public class AccountInfoController {

    @Autowired
    private AccountInfoDAO companyDAO;


    @Autowired
    private OrganizationTypeDAO organizationTypeDAO;

    @Autowired
    private OrganizationIndustryDAO organizationIndustryDAO;

    @ModelAttribute
    public void initValues(Model model) {

        model.addAttribute("orgTypes", organizationTypeDAO.list());
        model.addAttribute("orgIndustrys", organizationIndustryDAO.list());
    }

    @RequestMapping(value="/list")
    public ModelAndView list(ModelAndView model) throws IOException {
        List<AccountInfo> companyList = companyDAO.list();
        model.addObject("companyList", companyList);
        //model.addObject("orgType", companyList);
        model.setViewName("accountInfo/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        AccountInfo company = new AccountInfo();
        model.addObject("company", company);
        model.setViewName("accountInfo/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute AccountInfo company  ) {
        companyDAO.saveOrUpdate(company);
        return new ModelAndView("redirect:/accountInfo/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        companyDAO.delete(id);
        return new ModelAndView("redirect:/accountInfo/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        AccountInfo company = companyDAO.get(id);
        ModelAndView model = new ModelAndView("accountInfo/form");
        model.addObject("company", company);

        return model;
    }

    @RequestMapping(value = "/getOrgType", method = RequestMethod.GET)
    public @ResponseBody String test(@RequestParam("orgType") int id){
        return organizationTypeDAO.get(id).getName();
    }

    @RequestMapping(value = "/getOrgIndustry", method = RequestMethod.GET)
    public @ResponseBody String getOrgIndustry(@RequestParam("orgIndustry") int id){
        return organizationIndustryDAO.get(id).getName();
    }


}

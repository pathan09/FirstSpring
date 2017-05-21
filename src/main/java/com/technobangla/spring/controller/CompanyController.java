package com.technobangla.spring.controller;

import com.technobangla.spring.dao.CompanyDAO;
import com.technobangla.spring.dao.CompanyDAOImpl;
import com.technobangla.spring.dao.OrganizationIndustryDAO;
import com.technobangla.spring.dao.OrganizationTypeDAO;
import com.technobangla.spring.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyDAO companyDAO;

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
        List<Company> companyList = companyDAO.list();
        model.addObject("companyList", companyList);
        model.addObject("orgType", companyList);
        model.setViewName("company/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        Company company = new Company();
        model.addObject("company", company);
        model.setViewName("company/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Company company  ) {
        companyDAO.saveOrUpdate(company);
        return new ModelAndView("redirect:/company/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        companyDAO.delete(id);
        return new ModelAndView("redirect:/company/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Company company = companyDAO.get(id);
        ModelAndView model = new ModelAndView("company/form");
        model.addObject("company", company);

        return model;
    }

    public String getOrgType(int id){


        organizationTypeDAO.list();
        return "";
    }

    public String getOrgIndustry(int id){
        return organizationIndustryDAO.get(id).getName();
    }
}

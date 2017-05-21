package com.technobangla.spring.controller;

import com.technobangla.spring.dao.*;
import com.technobangla.spring.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/testData", method = RequestMethod.GET)
    public @ResponseBody String test(@RequestParam("orgType") int id){
        //int id = Integer.parseInt(request.getParameter("id"));
       // OrganizationTypeDAOImpl orgType=new OrganizationTypeDAOImpl(getDataSource());
        return organizationTypeDAO.get(id).getName();
    }

    public String getOrgType(int id){

        OrganizationTypeDAOImpl orgType=new OrganizationTypeDAOImpl(getDataSource());
        return orgType.get(id).getName();
    }

    public String getOrgIndustry(int id){
        OrganizationIndustryDAOImpl orgIndustry= new OrganizationIndustryDAOImpl(getDataSource());
        return orgIndustry.get(id).getName();
    }

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/erpdb");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }
}

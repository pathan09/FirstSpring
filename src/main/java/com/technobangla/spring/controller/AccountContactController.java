package com.technobangla.spring.controller;

import com.technobangla.spring.dao.*;
import com.technobangla.spring.model.AccountContact;
import com.technobangla.spring.model.Employee;
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
@RequestMapping("/accountContact")
public class AccountContactController {

    @Autowired
    private AccountInfoDAO accountInfoDAO;

    @Autowired
    AccountContactDAO accountContactDAO;

    @Autowired
    private DesignationDAO designationDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private CompanyDAO companyDAO;


    @ModelAttribute
    public void initValues(Model model) {

        model.addAttribute("designationList", designationDAO.list());
        model.addAttribute("departmentList", departmentDAO.list());
        model.addAttribute("companyList", companyDAO.list());
        model.addAttribute("accountInfoList", accountInfoDAO.list());
    }

    @RequestMapping(value="/list")
    public ModelAndView list(ModelAndView model) throws IOException {
        List<AccountContact> employeeList = accountContactDAO.list();
        model.addObject("employeeList", employeeList);
        model.setViewName("accountContact/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        AccountContact employee = new AccountContact();
        model.addObject("employee", employee);
        model.setViewName("accountContact/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute AccountContact employee  ) {
        accountContactDAO.saveOrUpdate(employee);
        return new ModelAndView("redirect:/accountContact/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        accountContactDAO.delete(id);
        return new ModelAndView("redirect:/accountContact/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        AccountContact employee = accountContactDAO.get(id);
        ModelAndView model = new ModelAndView("accountContact/form");
        model.addObject("employee", employee);

        return model;
    }

    @RequestMapping(value = "/getDesignation", method = RequestMethod.GET)
    public @ResponseBody String getDesignation(@RequestParam("orgIndustry") int id){
            return designationDAO.get(id).getName();
    }

    @RequestMapping(value = "/getDepartment", method = RequestMethod.GET)
    public @ResponseBody String getDepartment(@RequestParam("orgType") int id){
        return departmentDAO.get(id).getDepartmentName();
    }

    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    public @ResponseBody String getCompany(@RequestParam("companyId") int id){
        return companyDAO.get(id).getName();
    }


    @RequestMapping(value = "/getAccountInfo", method = RequestMethod.GET)
    public @ResponseBody String getAccountInfo(@RequestParam("accountInfoId") int id){
        return accountInfoDAO.get(id).getName();
    }

}

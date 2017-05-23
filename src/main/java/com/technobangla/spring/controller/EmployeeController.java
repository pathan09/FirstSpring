package com.technobangla.spring.controller;

import com.technobangla.spring.dao.*;
import com.technobangla.spring.model.Company;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;


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
    }

    @RequestMapping(value="/list")
    public ModelAndView list(ModelAndView model) throws IOException {
        List<Employee> employeeList = employeeDAO.list();
        model.addObject("employeeList", employeeList);
        model.setViewName("employee/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("employee/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Employee employee  ) {
        employeeDAO.saveOrUpdate(employee);
        return new ModelAndView("redirect:/employee/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.delete(id);
        return new ModelAndView("redirect:/employee/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.get(id);
        ModelAndView model = new ModelAndView("employee/form");
        model.addObject("employee", employee);

        return model;
    }

    @RequestMapping(value = "/getDesignation", method = RequestMethod.GET)
    public @ResponseBody String getDesignation(@RequestParam("designationId") int id){
        try {
            return designationDAO.get(id).getName();
        }catch (Exception e){
           return "";
        }

    }

    @RequestMapping(value = "/getDepartment", method = RequestMethod.GET)
    public @ResponseBody String getDepartment(@RequestParam("departmentId") int id){
        return departmentDAO.get(id).getDepartmentName();
    }

    @RequestMapping(value = "/getCompany", method = RequestMethod.GET)
    public @ResponseBody String getCompany(@RequestParam("companyId") int id){
        return companyDAO.get(id).getName();
    }


}

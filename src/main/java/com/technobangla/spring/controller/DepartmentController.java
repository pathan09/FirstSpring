package com.technobangla.spring.controller;

import com.technobangla.spring.dao.DepartmentDAO;
import com.technobangla.spring.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ayakuth Pathan on 13-May-17.
 */

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentDAO departmentDAO;

    @RequestMapping(value="/list")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Department> departmentList = departmentDAO.list();
        model.addObject("departmentList", departmentList);
        model.setViewName("department/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        Department department = new Department();
        model.addObject("department", department);
        model.setViewName("department/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Department department  ) {
        departmentDAO.saveOrUpdate(department);
        return new ModelAndView("redirect:/department/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        departmentDAO.delete(id);
        return new ModelAndView("redirect:/department/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Department department = departmentDAO.get(id);
        ModelAndView model = new ModelAndView("department/form");
        model.addObject("department", department);

        return model;
    }
}

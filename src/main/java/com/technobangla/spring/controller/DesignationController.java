package com.technobangla.spring.controller;

import com.technobangla.spring.dao.DesignationDAO;
import com.technobangla.spring.model.Designation;
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
@RequestMapping("/designation")
public class DesignationController {

    @Autowired
    private DesignationDAO designationDAO;

    @RequestMapping(value="/list")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<Designation> designationList = designationDAO.list();
        model.addObject("designationList", designationList);
        model.setViewName("designation/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        Designation designation = new Designation();
        model.addObject("designation", designation);
        model.setViewName("designation/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Designation designation  ) {
        designationDAO.saveOrUpdate(designation);
        return new ModelAndView("redirect:/designation/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        designationDAO.delete(id);
        return new ModelAndView("redirect:/designation/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Designation designation = designationDAO.get(id);
        ModelAndView model = new ModelAndView("designation/form");
        model.addObject("designation", designation);

        return model;
    }
}

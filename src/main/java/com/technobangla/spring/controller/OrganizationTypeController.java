package com.technobangla.spring.controller;

import com.technobangla.spring.dao.OrganizationTypeDAO;
import com.technobangla.spring.model.OrganizationType;
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
@RequestMapping("/organizationType")
public class OrganizationTypeController {

    @Autowired
    private OrganizationTypeDAO organizationTypeDAO;

    @RequestMapping(value="/list")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<OrganizationType> organizationTypeList = organizationTypeDAO.list();
        model.addObject("organizationTypeList", organizationTypeList);
        model.setViewName("organizationType/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        OrganizationType organizationType = new OrganizationType();
        model.addObject("organizationType", organizationType);
        model.setViewName("organizationType/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute OrganizationType organizationType ) {
        organizationTypeDAO.saveOrUpdate(organizationType);
        return new ModelAndView("redirect:/organizationType/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        organizationTypeDAO.delete(id);
        return new ModelAndView("redirect:/organizationType/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        OrganizationType organizationType = organizationTypeDAO.get(id);
        ModelAndView model = new ModelAndView("organizationType/form");
        model.addObject("organizationType", organizationType);

        return model;
    }
}

package com.technobangla.spring.controller;



import com.technobangla.spring.dao.OrganizationIndustryDAO;
import com.technobangla.spring.model.OrganizationIndustry;
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
@RequestMapping("/organizationIndustry")
public class OrganizationIndustryController {

    @Autowired
    private OrganizationIndustryDAO organizationIndustryDAO;

    @RequestMapping(value="/list")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<OrganizationIndustry> industryList = organizationIndustryDAO.list();
        model.addObject("industryList", industryList);
        model.setViewName("organizationIndustry/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        OrganizationIndustry industry = new OrganizationIndustry();
        model.addObject("industry", industry);
        model.setViewName("organizationIndustry/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute OrganizationIndustry industry  ) {
        organizationIndustryDAO.saveOrUpdate(industry);
        return new ModelAndView("redirect:/organizationIndustry/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        organizationIndustryDAO.delete(id);
        return new ModelAndView("redirect:/organizationIndustry/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        OrganizationIndustry industry = organizationIndustryDAO.get(id);
        ModelAndView model = new ModelAndView("organizationIndustry/form");
        model.addObject("industry", industry);

        return model;
    }
}

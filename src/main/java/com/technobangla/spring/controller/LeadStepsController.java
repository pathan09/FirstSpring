package com.technobangla.spring.controller;

import com.technobangla.spring.dao.LeadStepsDAO;
import com.technobangla.spring.model.LeadSteps;
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
@RequestMapping("/leadSteps")
public class LeadStepsController {

    @Autowired
    private LeadStepsDAO leadStepsDAO;

    @RequestMapping(value="/list")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<LeadSteps> leadStepsList = leadStepsDAO.list();
        model.addObject("leadStepsList", leadStepsList);
        model.setViewName("leadSteps/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        LeadSteps leadSteps = new LeadSteps();
        model.addObject("leadSteps", leadSteps);
        model.setViewName("leadSteps/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute LeadSteps leadSteps  ) {
        leadStepsDAO.saveOrUpdate(leadSteps);
        return new ModelAndView("redirect:/leadSteps/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        leadStepsDAO.delete(id);
        return new ModelAndView("redirect:/leadSteps/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        LeadSteps leadSteps = leadStepsDAO.get(id);
        ModelAndView model = new ModelAndView("leadSteps/form");
        model.addObject("leadSteps", leadSteps);

        return model;
    }
}

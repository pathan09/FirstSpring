package com.technobangla.spring.controller;

import com.technobangla.spring.dao.*;
import com.technobangla.spring.model.AccountInfo;
import com.technobangla.spring.model.LeadInfo;
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
@RequestMapping("/leadInfoWeb")
public class LeadInfoController {

    @Autowired
    private LeadInfoDAO leadInfoDAO;


    @Autowired
    private EmployeeDAO employeeDAO;



    @ModelAttribute
    public void initValues(Model model) {

        model.addAttribute("employeeList", employeeDAO.list());

    }

    @RequestMapping(value="/list")
    public ModelAndView list(ModelAndView model) throws IOException {
        List<LeadInfo> leadInfoList = leadInfoDAO.list();
        model.addObject("leadInfoList", leadInfoList);
        model.setViewName("leadInfo/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        LeadInfo leadInfo = new LeadInfo();
        model.addObject("leadInfo", leadInfo);
        model.setViewName("leadInfo/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute LeadInfo leadInfo  ) {
        leadInfoDAO.saveOrUpdate(leadInfo);
        return new ModelAndView("redirect:/leadInfo/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        leadInfoDAO.delete(id);
        return new ModelAndView("redirect:/leadInfo/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        LeadInfo leadInfo = leadInfoDAO.get(id);
        ModelAndView model = new ModelAndView("leadInfo/form");
        model.addObject("leadInfo", leadInfo);

        return model;
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public @ResponseBody String test(@RequestParam("employee") int id){
        return employeeDAO.get(id).getFirstName();
    }




}

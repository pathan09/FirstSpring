package com.technobangla.spring.controller;

import com.technobangla.spring.dao.DepartmentDAO;
import com.technobangla.spring.dao.EmployeeDAO;
import com.technobangla.spring.dao.UserDAO;
import com.technobangla.spring.model.Department;
import com.technobangla.spring.model.User;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @ModelAttribute
    public void initValues(Model model) {
        model.addAttribute("employeeList", employeeDAO.list());
    }

    @RequestMapping(value="/list")
    public ModelAndView listContact(ModelAndView model) throws IOException {
        List<User> userList = userDAO.list();
        model.addObject("userList", userList);
        model.setViewName("user/list");

        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/form");
        return model;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user  ) {
        userDAO.saveOrUpdate(user);
        return new ModelAndView("redirect:/user/list");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        return new ModelAndView("redirect:/user/list");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.get(id);
        ModelAndView model = new ModelAndView("user/form");
        model.addObject("user", user);

        return model;
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public @ResponseBody
    String test(@RequestParam("employeeId") int id){
        return employeeDAO.get(id).getFirstName()+" "+employeeDAO.get(id).getLastName();
    }

}

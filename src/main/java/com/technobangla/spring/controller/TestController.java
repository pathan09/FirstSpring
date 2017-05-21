package com.technobangla.spring.controller;

import com.technobangla.spring.dao.TestDAO;
import com.technobangla.spring.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * This controller routes accesses to the application to the appropriate
 * hanlder methods. 
 * @author www.codejava.net
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestDAO testDAO;
	
	@RequestMapping(value="/list")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		List<Test> testList = testDAO.list();
		model.addObject("testList", testList);
		model.setViewName("list");
		
		return model;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView create(ModelAndView model) {
		Test test = new Test();
		model.addObject("test", test);
		model.setViewName("form");
		return model;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Test test) {
		testDAO.saveOrUpdate(test);
		return new ModelAndView("redirect:/test/list");
	}
	
	/*@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int contactId = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(contactId);
		ModelAndView model = new ModelAndView("ContactForm");
		model.addObject("contact", contact);
		
		return model;
	}*/
}

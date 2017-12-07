package com.springapp.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/q")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        logger.info("9090");
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView=new ModelAndView();
        logger.info("9090");
        modelAndView.addObject("message", "Hello world!");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
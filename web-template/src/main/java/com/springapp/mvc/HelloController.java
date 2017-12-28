package com.springapp.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 模版web项目 比较
 */
@Controller
@RequestMapping("/my")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        logger.info("90190");
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        String type = httpServletRequest.getParameter("type");
        logger.info(type + "90290我2！@#¥%……*（）-=+_)(*&^%$#@!");
        modelAndView.addObject("message", "Hello world!90290我2！@#¥%……*（）-=+_)(*&^%$#@!");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
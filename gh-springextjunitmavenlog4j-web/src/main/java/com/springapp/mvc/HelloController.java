package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/controller")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        logger.debug(" debug {}","22");
        logger.error(" error {}","22");
        logger.info(" info {}","22");
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "ext",method = RequestMethod.GET)
    public String ext(ModelMap model) {
        logger.debug(" debug {}", "ext");
        logger.error(" error {}", "ext");
        logger.info(" info {}", "ext");
        return "exttest";
    }
}
package com.github.slw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
        logger.debug("debug printWelcome");
        logger.info("info printWelcome");
        logger.warn("warn printWelcome");
        logger.error("error printWelcome");
		model.addAttribute("message", "Hell22o world!");
		return "hello";
	}
}
package com.springapp.mvc;

import com.springapp.util.AesUtil;
import com.springapp.util.Base64Util;
import com.springapp.util.Md5Util;
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
@RequestMapping("/q")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        logger.info("90190");
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    /**
     * http://localhost:8080/q/index?type=加&key=756&data=uB7JfnCdDY%2fV7e3LcIeQTBkpOq
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info("90290");
        String key = httpServletRequest.getParameter("key");
        String type = httpServletRequest.getParameter("type");
        String data = httpServletRequest.getParameter("data");
        logger.info("type={} data={}", type, data);
        modelAndView.addObject("message", "Hello world!");
        if (type != null && null != data) {
            if (key != null) {

                if (type.equals("加")) {
                    modelAndView.addObject("message", AesUtil.aesEncrypt(data, key));
                } else {
                    modelAndView.addObject("message", AesUtil.aesDecrypt(data, key));
                }
            } else {

                if (type.equals("加")) {
                    modelAndView.addObject("message", AesUtil.aesEncrypt(data));
                } else {
                    modelAndView.addObject("message", AesUtil.aesDecrypt(data));
                }
            }
        }

        logger.info(new String(Base64Util.encode("90290".getBytes())));
        logger.info(Md5Util.md5("90290")+"我是");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
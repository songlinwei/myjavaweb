package com.springapp.mvc;

import com.springapp.model.*;
import com.springapp.service.ActivityService;
import com.springapp.service.PrizeLogService;
import com.springapp.service.PrizeService;
import com.springapp.service.UserService;
import com.springapp.util.LotteryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping("/")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    PrizeLogService prizeLogService;

    @Autowired
    PrizeService prizeService;


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome2(ModelMap model) {
        logger.debug(" debug {}", "22");
        logger.error(" error {}", "22");
        logger.info(" info {}", "22");
        model.addAttribute("message", "Hello world!");
        User user = new User();
        user.setCharset("22");
        user.setWebsite("233");
        int i = userService.insertUser(user);
        System.out.println("insertUser------------" + i);
        model.addAttribute("message", "" + i);
        ActivityModel activityModel = new ActivityModel();
        activityModel.setActivityInfo("1");
        activityModel.setActivityName("name");
        activityModel.setEndDate(new Date());
        activityModel.setStartDate(new Date());
        int activityId = activityService.insertActivity(activityModel);
        System.out.println("activityId------------" + activityId);
        PrizeLogModel prizeLogModel = new PrizeLogModel();
        prizeLogModel.setActivityId(1);
        prizeLogModel.setPrizeId(1);
        prizeLogModel.setuName("uname");
        prizeLogModel.setPrizeLogDate(new Date());
        int prizeLogId = prizeLogService.insertPrizeLog(prizeLogModel);
        System.out.println("prizeLogId------------" + prizeLogId);
        PrizeModel prizeModel = new PrizeModel();
        prizeModel.setPrizeName("name");
        prizeModel.setPrizeInfo("info");
        prizeModel.setPrizeNum(2);
        prizeModel.setPrizeProbability("2.1111111");
        prizeModel.setPrizeType(1);
        prizeModel.setStartDate(new Date());
        prizeModel.setEndDate(new Date());
        prizeModel.setActivityId(1);
        int prizeId = prizeService.insertPrize(prizeModel);
        System.out.println("prizeId------------" + prizeId);
        return "hello";
    }

    @RequestMapping(value = "chou", method = RequestMethod.GET)
    public ModelAndView printWelcome(String name) {
        ModelAndView modelAndView = new ModelAndView();
        logger.info(" info {}", "1");
        List<PrizeModel> prizeModelList = ModelC.prizeModelList;
        logger.info(" info {}", "2");
        List<Double> dList = new ArrayList<Double>();
        for (PrizeModel prizeModel : prizeModelList) {
            try {
                dList.add(Double.parseDouble(prizeModel.getPrizeProbability()));
                logger.info(" info {}", Double.parseDouble(prizeModel.getPrizeProbability()));
            } catch (NumberFormatException e) {
            }
        }

        logger.info(" info {}", "3");
        int index = LotteryUtil.lottery(dList);
        logger.info(" info {}--{}", "4", index);
        PrizeModel prizeModels = prizeModelList.get(index);
        logger.info(" info {}-{}", "5", name);
        ModelC.addPrizeLogList(prizeModels.getActivityId(), 1, "2w");
        logger.info(" info {}", "6");
        modelAndView.addObject("message", prizeModels.toString());
        modelAndView.setViewName("hello");
        logger.info(" info {}", "7");
        return modelAndView;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        logger.info(" info {}", "1");
        List<PrizeLogModel> prizeModelList = ModelC.prizeLogList;
        model.addAttribute("message", prizeModelList.toString());
        logger.info(" info {}", "7");
        return "hello";
    }


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String adminGiftPage(ModelMap model) {
        model.addAttribute("admin", "adminGiftPage Hello world!");
        return "adminGiftPage";
    }


}
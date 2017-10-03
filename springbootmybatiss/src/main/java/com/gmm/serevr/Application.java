package com.gmm.serevr;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 古美門 on 2017-07-11 18:13.
 */
@Controller
@SpringBootApplication
public class Application {

    private static Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        logger.info("====SpringBootStartSuccess====");
    }

    /**
     * SpringBoot启动之后重定向到初始页面;
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "redirect:web/user/list";
    }
}

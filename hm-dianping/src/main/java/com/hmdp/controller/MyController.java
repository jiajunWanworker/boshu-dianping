package com.hmdp.controller;

import com.hmdp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 万佳军
 */
@Controller
@Slf4j
@RequestMapping("/users")
public class MyController {
@RequestMapping("1")
    public @ResponseBody  User test(@RequestBody User users) {


     User user = new User();
    log.info("User:{} ",user);
        log.info("id:{} ",users.getPhone());
        log.info("1phone:{} ",users.getId());
        return user;


    }
}

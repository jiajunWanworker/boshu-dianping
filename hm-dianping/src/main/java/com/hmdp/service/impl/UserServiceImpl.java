package com.hmdp.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Resource
    StringRedisTemplate stringRedisTemplate;
    /***
     *发送验证码
     * @param phone
     * @return
     */
    @Override
    public Result sendCode(String phone) {
        // 校验手机号
        boolean phoneInvalid = RegexUtils.isPhoneInvalid(phone);
        if (!phoneInvalid){
            return Result.fail("手机号不正确");
        }
        // 创建验证码
        String code = RandomUtil.randomNumbers(4);
        //保存验证码到redis
        stringRedisTemplate.opsForValue().set("login:code:"+phone,code);
        //发送验证码
        log.info("验证码是{}",code);
        //返回结果

        return Result.ok("验证码发送成功");
    }

    @Override
    public Result loginUser(LoginFormDTO loginForm) {


        return null;
    }
}

package com.hzf.service.core.controller;


import com.hzf.service.core.entity.UserInfo;
import com.hzf.service.core.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 用户基本信息 前端控制器
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@Api(tags = "用户信息管理", description = "用户信息管理接口")
@RestController
@RequestMapping("/web/core/userInfo")
public class UserInfoController {
    @Resource
    private IUserInfoService iUserInfoService;

    @ApiOperation(value = "获取用户信息", notes = "获取所有用户信息")
    @RequestMapping("/getUserInfo")
    public List<UserInfo> listAll(){
        return iUserInfoService.list();
    }
}


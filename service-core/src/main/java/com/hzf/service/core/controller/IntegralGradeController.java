package com.hzf.service.core.controller;


import com.hzf.service.core.entity.IntegralGrade;
import com.hzf.service.core.service.IIntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分等级表 前端控制器
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@Api(tags = "网站积分等级管理", description = "网站积分等级管理接口")
@RestController
@RequestMapping("/web/core/integralGrade")
public class IntegralGradeController {
    @Resource
    private IIntegralGradeService iIntegralGradeService;

    @ApiOperation(value = "查询所有积分等级列表", notes = "查询所有积分等级列表")
    @RequestMapping("/listAllWeb")
    public List<IntegralGrade> listAll(){
        return iIntegralGradeService.list();
    }

}


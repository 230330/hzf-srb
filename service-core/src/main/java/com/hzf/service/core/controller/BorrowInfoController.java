package com.hzf.service.core.controller;

import com.hzf.service.core.entity.BorrowInfo;
import com.hzf.service.core.service.IBorrowInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 借款信息表 前端控制器
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@Api(tags = "借款信息表")
@RestController
@RequestMapping("/web/core/borrowInfo")
public class BorrowInfoController {

    @Resource
    private IBorrowInfoService iBorrowInfoService;
    /**
     * 获取所有借款信息
     */
    @RequestMapping("/getAllBorrowInfo")
    public List<BorrowInfo> getAllBorrowInfo() {
        return iBorrowInfoService.list();
    }
}


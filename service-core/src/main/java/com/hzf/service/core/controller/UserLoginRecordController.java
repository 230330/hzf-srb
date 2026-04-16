package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.UserLoginRecord;
import com.hzf.service.core.service.IUserLoginRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登录记录 前端控制器
 * <p>
 * 提供用户登录记录的查询接口，包括：
 * - 查询所有用户登录记录列表
 * - 根据ID查询用户登录记录
 * - 根据用户ID查询登录记录列表
 * </p>
 * <p>
 * 业务逻辑均在 Service 层处理，Controller 仅负责接收请求和封装响应
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@RestController
@RequestMapping("/web/core/userLoginRecord")
@Api(tags = "用户登录记录")
@Slf4j
public class UserLoginRecordController {

    /**
     * 用户登录记录服务接口
     */
    @Resource
    private IUserLoginRecordService iUserLoginRecordService;

    /**
     * 查询所有用户登录记录列表
     *
     * @return 包含所有用户登录记录列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有用户登录记录列表")
    public Result listAll() {
        List<UserLoginRecord> list = iUserLoginRecordService.list();
        return Result.success().data("list", list).message("查询所有用户登录记录列表成功");
    }

    /**
     * 根据ID查询用户登录记录
     *
     * @param id 用户登录记录ID
     * @return 包含用户登录记录信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询用户登录记录", notes = "根据 ID 查询用户登录记录")
    public Result getById(@PathVariable Long id) {
        UserLoginRecord userLoginRecord = iUserLoginRecordService.getUserLoginRecordById(id);
        return Result.success().data("userLoginRecord", userLoginRecord).message("根据 ID 查询用户登录记录成功");
    }

    /**
     * 根据用户ID查询登录记录列表
     *
     * @param userId 用户ID
     * @return 包含用户登录记录列表的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询登录记录", notes = "根据用户ID查询登录记录")
    public Result getByUserId(@PathVariable Long userId) {
        List<UserLoginRecord> list = iUserLoginRecordService.getUserLoginRecordByUserId(userId);
        return Result.success().data("list", list).message("根据用户ID查询登录记录成功");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增用户登录记录", notes = "新增用户登录记录")
    public Result save(@RequestBody UserLoginRecord userLoginRecord) {
        iUserLoginRecordService.saveUserLoginRecord(userLoginRecord);
        return Result.success().message("新增用户登录记录成功");
    }

    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新用户登录记录", notes = "根据ID更新用户登录记录")
    public Result updateById(@PathVariable Long id, @RequestBody UserLoginRecord userLoginRecord) {
        iUserLoginRecordService.updateUserLoginRecordById(id, userLoginRecord);
        return Result.success().message("更新用户登录记录成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除用户登录记录", notes = "根据ID删除用户登录记录")
    public Result deleteById(@PathVariable Long id) {
        iUserLoginRecordService.removeUserLoginRecordById(id);
        return Result.success().message("删除用户登录记录成功");
    }
}

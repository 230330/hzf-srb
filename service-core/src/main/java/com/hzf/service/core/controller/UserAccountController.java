package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.UserAccount;
import com.hzf.service.core.service.IUserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户账户 前端控制器
 * <p>
 * 提供用户账户的查询接口，包括：
 * - 查询所有用户账户列表
 * - 根据ID查询用户账户
 * - 根据用户ID查询用户账户
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
@RequestMapping("/web/core/userAccount")
@Api(tags = "用户账户")
@Slf4j
public class UserAccountController {

    /**
     * 用户账户服务接口
     */
    @Resource
    private IUserAccountService iUserAccountService;

    /**
     * 查询所有用户账户列表
     *
     * @return 包含所有用户账户列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有用户账户列表")
    public Result listAll() {
        List<UserAccount> list = iUserAccountService.list();
        return Result.success().data("list", list).message("查询所有用户账户列表成功");
    }

    /**
     * 根据ID查询用户账户
     *
     * @param id 用户账户ID
     * @return 包含用户账户信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询用户账户", notes = "根据 ID 查询用户账户")
    public Result getById(@PathVariable Long id) {
        UserAccount userAccount = iUserAccountService.getUserAccountById(id);
        return Result.success().data("userAccount", userAccount).message("根据 ID 查询用户账户成功");
    }

    /**
     * 根据用户ID查询用户账户
     *
     * @param userId 用户ID
     * @return 包含用户账户信息的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询用户账户", notes = "根据用户ID查询用户账户")
    public Result getByUserId(@PathVariable Long userId) {
        UserAccount userAccount = iUserAccountService.getUserAccountByUserId(userId);
        return Result.success().data("userAccount", userAccount).message("根据用户ID查询用户账户成功");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增用户账户", notes = "新增用户账户")
    public Result save(@RequestBody UserAccount userAccount) {
        iUserAccountService.saveUserAccount(userAccount);
        return Result.success().message("新增用户账户成功");
    }

    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新用户账户", notes = "根据ID更新用户账户")
    public Result updateById(@PathVariable Long id, @RequestBody UserAccount userAccount) {
        iUserAccountService.updateUserAccountById(id, userAccount);
        return Result.success().message("更新用户账户成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除用户账户", notes = "根据ID删除用户账户")
    public Result deleteById(@PathVariable Long id) {
        iUserAccountService.removeUserAccountById(id);
        return Result.success().message("删除用户账户成功");
    }
}
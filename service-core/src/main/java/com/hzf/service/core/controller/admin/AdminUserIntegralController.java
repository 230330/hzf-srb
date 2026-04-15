package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.UserIntegral;
import com.hzf.service.core.service.IUserIntegralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户积分记录管理 前端控制器
 * <p>
 * 提供用户积分记录的增删改查接口，包括：
 * - 查询所有用户积分记录列表
 * - 新增用户积分记录
 * - 根据ID查询用户积分记录
 * - 根据用户ID查询积分记录列表
 * - 根据ID更新用户积分记录
 * - 根据ID删除用户积分记录（逻辑删除）
 * </p>
 * <p>
 * 业务逻辑均在 Service 层处理，Controller 仅负责接收请求和封装响应
 * </p>
 *
 * @author hzf
 * @since 2026-04-15
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/core/userIntegral")
@Api(tags = "用户积分记录管理")
@Slf4j
public class AdminUserIntegralController {

    /**
     * 用户积分记录服务接口
     */
    @Resource
    private IUserIntegralService iUserIntegralService;

    /**
     * 查询所有用户积分记录列表
     *
     * @return 包含所有用户积分记录列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有用户积分记录列表")
    public Result listAll() {
        List<UserIntegral> list = iUserIntegralService.list();
        return Result.success().data("list", list).message("查询所有用户积分记录列表成功");
    }

    /**
     * 新增用户积分记录
     *
     * @param userIntegral 用户积分记录实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增用户积分记录", notes = "新增用户积分记录")
    public Result save(@RequestBody UserIntegral userIntegral) {
        iUserIntegralService.saveUserIntegral(userIntegral);
        return Result.success().message("新增用户积分记录成功");
    }

    /**
     * 根据ID查询用户积分记录
     *
     * @param id 用户积分记录ID
     * @return 包含用户积分记录信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询用户积分记录", notes = "根据 ID 查询用户积分记录")
    public Result getById(@PathVariable Long id) {
        UserIntegral userIntegral = iUserIntegralService.getUserIntegralById(id);
        return Result.success().data("userIntegral", userIntegral).message("根据 ID 查询用户积分记录成功");
    }

    /**
     * 根据用户ID查询积分记录列表
     *
     * @param userId 用户ID
     * @return 包含用户积分记录列表的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询积分记录", notes = "根据用户ID查询积分记录")
    public Result getByUserId(@PathVariable Long userId) {
        List<UserIntegral> list = iUserIntegralService.getUserIntegralByUserId(userId);
        return Result.success().data("list", list).message("根据用户ID查询积分记录成功");
    }

    /**
     * 根据ID更新用户积分记录
     *
     * @param id           用户积分记录ID
     * @param userIntegral 用户积分记录实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新用户积分记录", notes = "根据 ID 更新用户积分记录")
    public Result updateById(@PathVariable Long id, @RequestBody UserIntegral userIntegral) {
        iUserIntegralService.updateUserIntegralById(id, userIntegral);
        return Result.success().message("更新用户积分记录成功");
    }

    /**
     * 根据ID删除用户积分记录（逻辑删除）
     *
     * @param id 用户积分记录ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除用户积分记录", notes = "逻辑删除用户积分记录")
    public Result removeById(@PathVariable Long id) {
        iUserIntegralService.removeUserIntegralById(id);
        return Result.success().message("删除用户积分记录成功");
    }
}

package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.UserBind;
import com.hzf.service.core.service.IUserBindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户绑定管理 前端控制器
 * <p>
 * 提供用户绑定的增删改查接口，包括：
 * - 查询所有用户绑定列表
 * - 新增用户绑定
 * - 根据ID查询用户绑定
 * - 根据用户ID查询用户绑定
 * - 根据ID更新用户绑定
 * - 根据ID删除用户绑定（逻辑删除）
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
@RequestMapping("/admin/core/userBind")
@Api(tags = "用户绑定管理")
@Slf4j
public class AdminUserBindController {

    /**
     * 用户绑定服务接口
     */
    @Resource
    private IUserBindService iUserBindService;

    /**
     * 查询所有用户绑定列表
     *
     * @return 包含所有用户绑定列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有用户绑定列表")
    public Result listAll() {
        List<UserBind> list = iUserBindService.list();
        return Result.success().data("list", list).message("查询所有用户绑定列表成功");
    }

    /**
     * 新增用户绑定
     *
     * @param userBind 用户绑定实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增用户绑定", notes = "新增用户绑定")
    public Result save(@RequestBody UserBind userBind) {
        iUserBindService.saveUserBind(userBind);
        return Result.success().message("新增用户绑定成功");
    }

    /**
     * 根据ID查询用户绑定
     *
     * @param id 用户绑定ID
     * @return 包含用户绑定信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询用户绑定", notes = "根据 ID 查询用户绑定")
    public Result getById(@PathVariable Long id) {
        UserBind userBind = iUserBindService.getUserBindById(id);
        return Result.success().data("userBind", userBind).message("根据 ID 查询用户绑定成功");
    }

    /**
     * 根据用户ID查询用户绑定
     *
     * @param userId 用户ID
     * @return 包含用户绑定信息的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询用户绑定", notes = "根据用户ID查询用户绑定")
    public Result getByUserId(@PathVariable Long userId) {
        UserBind userBind = iUserBindService.getUserBindByUserId(userId);
        return Result.success().data("userBind", userBind).message("根据用户ID查询用户绑定成功");
    }

    /**
     * 根据ID更新用户绑定
     *
     * @param id       用户绑定ID
     * @param userBind 用户绑定实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新用户绑定", notes = "根据 ID 更新用户绑定")
    public Result updateById(@PathVariable Long id, @RequestBody UserBind userBind) {
        iUserBindService.updateUserBindById(id, userBind);
        return Result.success().message("更新用户绑定成功");
    }

    /**
     * 根据ID删除用户绑定（逻辑删除）
     *
     * @param id 用户绑定ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除用户绑定", notes = "逻辑删除用户绑定")
    public Result removeById(@PathVariable Long id) {
        iUserBindService.removeUserBindById(id);
        return Result.success().message("删除用户绑定成功");
    }
}

package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.UserInfo;
import com.hzf.service.core.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员用户信息 前端控制器
 * <p>
 * 提供用户信息的增删改查接口，包括：
 * - 查询所有用户信息列表
 * - 新增用户信息
 * - 根据ID查询用户信息
 * - 根据姓名查询用户信息
 * - 根据证件号码查询用户信息
 * - 根据ID更新用户信息
 * - 根据ID删除用户信息（逻辑删除）
 * </p>
 * <p>
 * 业务逻辑均在 Service 层处理，Controller 仅负责接收请求和封装响应
 * </p>
 *
 * @author hzf
 * @since 2026-04-10
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/core/userInfo")
@Api(tags = "管理员-用户信息管理", description = "管理员用户信息管理接口")
@Slf4j
public class AdminUserInfoController {

    /**
     * 用户信息服务接口
     */
    @Resource
    private IUserInfoService iUserInfoService;

    /**
     * 查询所有用户信息列表
     *
     * @return 包含所有用户信息列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有用户信息列表")
    public Result listAll() {
        List<UserInfo> list = iUserInfoService.list();
        return Result.success().data("list", list).message("查询所有用户信息成功");
    }

    /**
     * 新增用户信息
     *
     * @param userInfo 用户信息实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    public Result save(@RequestBody UserInfo userInfo) {
        iUserInfoService.saveUserInfo(userInfo);
        return Result.success().message("新增用户信息成功");
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id 用户ID
     * @return 包含用户信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询用户信息", notes = "根据 ID 查询用户信息")
    public Result getById(@PathVariable Long id) {
        UserInfo userInfo = iUserInfoService.getUserInfoById(id);
        return Result.success().data("userInfo", userInfo).message("根据 ID 查询用户信息成功");
    }

    /**
     * 根据姓名查询用户信息
     *
     * @param name 用户姓名
     * @return 包含用户信息列表的统一响应结果
     */
    @GetMapping("/getByName/{name}")
    @ApiOperation(value = "根据姓名查询用户信息", notes = "根据姓名查询用户信息")
    public Result getByName(@PathVariable String name) {
        List<UserInfo> list = iUserInfoService.listByName(name);
        return Result.success().data("list", list).message("根据姓名查询用户信息成功");
    }

    /**
     * 根据证件号码查询用户信息
     *
     * @param idCard 身份证号
     * @return 包含用户信息的统一响应结果
     */
    @GetMapping("/getByIdCard/{idCard}")
    @ApiOperation(value = "根据证件号码查询用户信息", notes = "根据证件号码查询用户信息")
    public Result getByIdCard(@PathVariable String idCard) {
        UserInfo userInfo = iUserInfoService.getByIdCard(idCard);
        return Result.success().data("userInfo", userInfo).message("根据证件号码查询用户信息成功");
    }

    /**
     * 根据ID更新用户信息
     *
     * @param id       用户ID
     * @param userInfo 用户信息实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新用户信息", notes = "根据 ID 更新用户信息")
    public Result updateById(@PathVariable Long id, @RequestBody UserInfo userInfo) {
        iUserInfoService.updateUserInfoById(id, userInfo);
        return Result.success().message("更新用户信息成功");
    }

    /**
     * 根据ID删除用户信息（逻辑删除）
     *
     * @param id 用户ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除用户信息", notes = "逻辑删除用户信息")
    public Result removeById(@PathVariable Long id) {
        iUserInfoService.removeUserInfoById(id);
        return Result.success().message("删除用户信息成功");
    }
}

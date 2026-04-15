package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.LendReturn;
import com.hzf.service.core.service.ILendReturnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 还款记录管理 前端控制器
 * <p>
 * 提供还款记录的增删改查接口，包括：
 * - 查询所有还款记录列表
 * - 新增还款记录
 * - 根据ID查询还款记录
 * - 根据标的ID查询还款记录列表
 * - 根据用户ID查询还款记录列表
 * - 根据ID更新还款记录
 * - 根据ID删除还款记录（逻辑删除）
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
@RequestMapping("/admin/core/lendReturn")
@Api(tags = "还款记录管理")
@Slf4j
public class AdminLendReturnController {

    /**
     * 还款记录服务接口
     */
    @Resource
    private ILendReturnService iLendReturnService;

    /**
     * 查询所有还款记录列表
     *
     * @return 包含所有还款记录列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有还款记录列表")
    public Result listAll() {
        List<LendReturn> list = iLendReturnService.list();
        return Result.success().data("list", list).message("查询所有还款记录列表成功");
    }

    /**
     * 新增还款记录
     *
     * @param lendReturn 还款记录实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增还款记录", notes = "新增还款记录")
    public Result save(@RequestBody LendReturn lendReturn) {
        iLendReturnService.saveLendReturn(lendReturn);
        return Result.success().message("新增还款记录成功");
    }

    /**
     * 根据ID查询还款记录
     *
     * @param id 还款记录ID
     * @return 包含还款记录信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询还款记录", notes = "根据 ID 查询还款记录")
    public Result getById(@PathVariable Long id) {
        LendReturn lendReturn = iLendReturnService.getLendReturnById(id);
        return Result.success().data("lendReturn", lendReturn).message("根据 ID 查询还款记录成功");
    }

    /**
     * 根据标的ID查询还款记录列表
     *
     * @param lendId 标的ID
     * @return 包含还款记录列表的统一响应结果
     */
    @GetMapping("/getByLendId/{lendId}")
    @ApiOperation(value = "根据标的ID查询还款记录", notes = "根据标的ID查询还款记录")
    public Result getByLendId(@PathVariable Long lendId) {
        List<LendReturn> list = iLendReturnService.getLendReturnByLendId(lendId);
        return Result.success().data("list", list).message("根据标的ID查询还款记录成功");
    }

    /**
     * 根据用户ID查询还款记录列表
     *
     * @param userId 借款人用户ID
     * @return 包含还款记录列表的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询还款记录", notes = "根据用户ID查询还款记录")
    public Result getByUserId(@PathVariable Long userId) {
        List<LendReturn> list = iLendReturnService.getLendReturnByUserId(userId);
        return Result.success().data("list", list).message("根据用户ID查询还款记录成功");
    }

    /**
     * 根据ID更新还款记录
     *
     * @param id         还款记录ID
     * @param lendReturn 还款记录实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新还款记录", notes = "根据 ID 更新还款记录")
    public Result updateById(@PathVariable Long id, @RequestBody LendReturn lendReturn) {
        iLendReturnService.updateLendReturnById(id, lendReturn);
        return Result.success().message("更新还款记录成功");
    }

    /**
     * 根据ID删除还款记录（逻辑删除）
     *
     * @param id 还款记录ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除还款记录", notes = "逻辑删除还款记录")
    public Result removeById(@PathVariable Long id) {
        iLendReturnService.removeLendReturnById(id);
        return Result.success().message("删除还款记录成功");
    }
}

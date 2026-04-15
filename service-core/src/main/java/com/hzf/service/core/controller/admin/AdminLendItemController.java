package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.LendItem;
import com.hzf.service.core.service.ILendItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标的出借记录管理 前端控制器
 * <p>
 * 提供标的出借记录的增删改查接口，包括：
 * - 查询所有标的出借记录列表
 * - 新增标的出借记录
 * - 根据ID查询标的出借记录
 * - 根据标的ID查询出借记录列表
 * - 根据投资用户ID查询出借记录列表
 * - 根据ID更新标的出借记录
 * - 根据ID删除标的出借记录（逻辑删除）
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
@RequestMapping("/admin/core/lendItem")
@Api(tags = "标的出借记录管理")
@Slf4j
public class AdminLendItemController {

    /**
     * 标的出借记录服务接口
     */
    @Resource
    private ILendItemService iLendItemService;

    /**
     * 查询所有标的出借记录列表
     *
     * @return 包含所有标的出借记录列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有标的出借记录列表")
    public Result listAll() {
        List<LendItem> list = iLendItemService.list();
        return Result.success().data("list", list).message("查询所有标的出借记录列表成功");
    }

    /**
     * 新增标的出借记录
     *
     * @param lendItem 标的出借记录实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增标的出借记录", notes = "新增标的出借记录")
    public Result save(@RequestBody LendItem lendItem) {
        iLendItemService.saveLendItem(lendItem);
        return Result.success().message("新增标的出借记录成功");
    }

    /**
     * 根据ID查询标的出借记录
     *
     * @param id 标的出借记录ID
     * @return 包含标的出借记录信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询标的出借记录", notes = "根据 ID 查询标的出借记录")
    public Result getById(@PathVariable Long id) {
        LendItem lendItem = iLendItemService.getLendItemById(id);
        return Result.success().data("lendItem", lendItem).message("根据 ID 查询标的出借记录成功");
    }

    /**
     * 根据标的ID查询出借记录列表
     *
     * @param lendId 标的ID
     * @return 包含标的出借记录列表的统一响应结果
     */
    @GetMapping("/getByLendId/{lendId}")
    @ApiOperation(value = "根据标的ID查询出借记录", notes = "根据标的ID查询出借记录")
    public Result getByLendId(@PathVariable Long lendId) {
        List<LendItem> list = iLendItemService.getLendItemByLendId(lendId);
        return Result.success().data("list", list).message("根据标的ID查询出借记录成功");
    }

    /**
     * 根据投资用户ID查询出借记录列表
     *
     * @param investUserId 投资用户ID
     * @return 包含标的出借记录列表的统一响应结果
     */
    @GetMapping("/getByInvestUserId/{investUserId}")
    @ApiOperation(value = "根据投资用户ID查询出借记录", notes = "根据投资用户ID查询出借记录")
    public Result getByInvestUserId(@PathVariable Long investUserId) {
        List<LendItem> list = iLendItemService.getLendItemByInvestUserId(investUserId);
        return Result.success().data("list", list).message("根据投资用户ID查询出借记录成功");
    }

    /**
     * 根据ID更新标的出借记录
     *
     * @param id       标的出借记录ID
     * @param lendItem 标的出借记录实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新标的出借记录", notes = "根据 ID 更新标的出借记录")
    public Result updateById(@PathVariable Long id, @RequestBody LendItem lendItem) {
        iLendItemService.updateLendItemById(id, lendItem);
        return Result.success().message("更新标的出借记录成功");
    }

    /**
     * 根据ID删除标的出借记录（逻辑删除）
     *
     * @param id 标的出借记录ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除标的出借记录", notes = "逻辑删除标的出借记录")
    public Result removeById(@PathVariable Long id) {
        iLendItemService.removeLendItemById(id);
        return Result.success().message("删除标的出借记录成功");
    }
}

package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.Lend;
import com.hzf.service.core.service.ILendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标的 前端控制器
 * <p>
 * 提供标的的查询接口，包括：
 * - 查询所有标的列表
 * - 根据ID查询标的
 * - 根据借款用户ID查询标的列表
 * - 根据标的编号查询标的
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
@RequestMapping("/web/core/lend")
@Api(tags = "标的")
@Slf4j
public class LendController {

    /**
     * 标的服务接口
     */
    @Resource
    private ILendService iLendService;

    /**
     * 查询所有标的列表
     *
     * @return 包含所有标的列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有标的列表")
    public Result listAll() {
        List<Lend> list = iLendService.list();
        return Result.success().data("list", list).message("查询所有标的列表成功");
    }

    /**
     * 根据ID查询标的
     *
     * @param id 标的ID
     * @return 包含标的信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询标的", notes = "根据 ID 查询标的")
    public Result getById(@PathVariable Long id) {
        Lend lend = iLendService.getLendById(id);
        return Result.success().data("lend", lend).message("根据 ID 查询标的成功");
    }

    /**
     * 根据借款用户ID查询标的列表
     *
     * @param userId 借款用户ID
     * @return 包含标的列表的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据借款用户ID查询标的", notes = "根据借款用户ID查询标的")
    public Result getByUserId(@PathVariable Long userId) {
        List<Lend> list = iLendService.getLendByUserId(userId);
        return Result.success().data("list", list).message("根据借款用户ID查询标的成功");
    }

    /**
     * 根据标的编号查询标的
     *
     * @param lendNo 标的编号
     * @return 包含标的信息的统一响应结果
     */
    @GetMapping("/getByLendNo/{lendNo}")
    @ApiOperation(value = "根据标的编号查询标的", notes = "根据标的编号查询标的")
    public Result getByLendNo(@PathVariable String lendNo) {
        Lend lend = iLendService.getLendByLendNo(lendNo);
        return Result.success().data("lend", lend).message("根据标的编号查询标的成功");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增标的", notes = "新增标的")
    public Result save(@RequestBody Lend lend) {
        iLendService.saveLend(lend);
        return Result.success().message("新增标的成功");
    }

    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新标的", notes = "根据ID更新标的")
    public Result updateById(@PathVariable Long id, @RequestBody Lend lend) {
        iLendService.updateLendById(id, lend);
        return Result.success().message("更新标的成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除标的", notes = "根据ID删除标的")
    public Result deleteById(@PathVariable Long id) {
        iLendService.removeLendById(id);
        return Result.success().message("删除标的成功");
    }
}

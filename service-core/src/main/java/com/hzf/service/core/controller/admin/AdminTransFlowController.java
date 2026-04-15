package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.TransFlow;
import com.hzf.service.core.service.ITransFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 交易流水管理 前端控制器
 * <p>
 * 提供交易流水的增删改查接口，包括：
 * - 查询所有交易流水列表
 * - 新增交易流水
 * - 根据ID查询交易流水
 * - 根据用户ID查询交易流水列表
 * - 根据交易单号查询交易流水
 * - 根据ID更新交易流水
 * - 根据ID删除交易流水（逻辑删除）
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
@RequestMapping("/admin/core/transFlow")
@Api(tags = "交易流水管理")
@Slf4j
public class AdminTransFlowController {

    /**
     * 交易流水服务接口
     */
    @Resource
    private ITransFlowService iTransFlowService;

    /**
     * 查询所有交易流水列表
     *
     * @return 包含所有交易流水列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有交易流水列表")
    public Result listAll() {
        List<TransFlow> list = iTransFlowService.list();
        return Result.success().data("list", list).message("查询所有交易流水列表成功");
    }

    /**
     * 新增交易流水
     *
     * @param transFlow 交易流水实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增交易流水", notes = "新增交易流水")
    public Result save(@RequestBody TransFlow transFlow) {
        iTransFlowService.saveTransFlow(transFlow);
        return Result.success().message("新增交易流水成功");
    }

    /**
     * 根据ID查询交易流水
     *
     * @param id 交易流水ID
     * @return 包含交易流水信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询交易流水", notes = "根据 ID 查询交易流水")
    public Result getById(@PathVariable Long id) {
        TransFlow transFlow = iTransFlowService.getTransFlowById(id);
        return Result.success().data("transFlow", transFlow).message("根据 ID 查询交易流水成功");
    }

    /**
     * 根据用户ID查询交易流水列表
     *
     * @param userId 用户ID
     * @return 包含交易流水列表的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询交易流水", notes = "根据用户ID查询交易流水")
    public Result getByUserId(@PathVariable Long userId) {
        List<TransFlow> list = iTransFlowService.getTransFlowByUserId(userId);
        return Result.success().data("list", list).message("根据用户ID查询交易流水成功");
    }

    /**
     * 根据交易单号查询交易流水
     *
     * @param transNo 交易单号
     * @return 包含交易流水信息的统一响应结果
     */
    @GetMapping("/getByTransNo/{transNo}")
    @ApiOperation(value = "根据交易单号查询交易流水", notes = "根据交易单号查询交易流水")
    public Result getByTransNo(@PathVariable String transNo) {
        TransFlow transFlow = iTransFlowService.getTransFlowByTransNo(transNo);
        return Result.success().data("transFlow", transFlow).message("根据交易单号查询交易流水成功");
    }

    /**
     * 根据ID更新交易流水
     *
     * @param id        交易流水ID
     * @param transFlow 交易流水实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新交易流水", notes = "根据 ID 更新交易流水")
    public Result updateById(@PathVariable Long id, @RequestBody TransFlow transFlow) {
        iTransFlowService.updateTransFlowById(id, transFlow);
        return Result.success().message("更新交易流水成功");
    }

    /**
     * 根据ID删除交易流水（逻辑删除）
     *
     * @param id 交易流水ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除交易流水", notes = "逻辑删除交易流水")
    public Result removeById(@PathVariable Long id) {
        iTransFlowService.removeTransFlowById(id);
        return Result.success().message("删除交易流水成功");
    }
}

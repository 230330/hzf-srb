package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.IntegralGrade;
import com.hzf.service.core.service.IIntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 积分等级管理 前端控制器
 * <p>
 * 提供积分等级的增删改查接口，包括：
 * - 查询所有积分等级列表
 * - 新增积分等级
 * - 根据ID查询积分等级
 * - 根据ID更新积分等级
 * - 根据ID删除积分等级（逻辑删除）
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
@RequestMapping("/admin/core/integralGrade")
@Api(tags = "积分等级管理")
@Slf4j
public class AdminIntegralGradeController {

    /**
     * 积分等级服务接口
     */
    @Resource
    private IIntegralGradeService iIntegralGradeService;

    /**
     * 查询所有积分等级列表
     *
     * @return 包含所有积分等级列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有积分等级列表")
    public Result listAll() {
        List<IntegralGrade> list = iIntegralGradeService.list();
        return Result.success().data("list", list).message("查询所有积分等级列表成功");
    }

    /**
     * 新增积分等级
     *
     * @param integralGrade 积分等级实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存积分等级", notes = "保存积分等级")
    public Result save(@RequestBody IntegralGrade integralGrade) {
        iIntegralGradeService.saveIntegralGrade(integralGrade);
        return Result.success().message("保存积分等级成功");
    }

    /**
     * 根据ID查询积分等级
     *
     * @param id 积分等级ID
     * @return 包含积分等级信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询积分等级", notes = "根据 ID 查询积分等级")
    public Result getById(@PathVariable Long id) {
        IntegralGrade integralGrade = iIntegralGradeService.getIntegralGradeById(id);
        return Result.success().data("integralGrade", integralGrade).message("根据 ID 查询积分等级成功");
    }

    /**
     * 根据ID更新积分等级
     *
     * @param id            积分等级ID
     * @param integralGrade 积分等级实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新积分等级", notes = "根据 ID 更新积分等级")
    public Result updateById(@PathVariable Long id, @RequestBody IntegralGrade integralGrade) {
        iIntegralGradeService.updateIntegralGradeById(id, integralGrade);
        return Result.success().message("更新积分等级成功");
    }

    /**
     * 根据ID删除积分等级（逻辑删除）
     *
     * @param id 积分等级ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除积分等级", notes = "逻辑删除积分等级")
    public Result removeById(@PathVariable Long id) {
        iIntegralGradeService.removeIntegralGradeById(id);
        return Result.success().message("删除积分等级成功");
    }

}


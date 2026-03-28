package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.guigu.common.result.ResponseEnum;
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
 * - 根据ID删除积分等级（逻辑删除）
 * - 保存或更新积分等级
 * - 根据ID查询积分等级
 * - 根据ID更新积分等级
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/core/integralGrade")
@Api(tags = "积分等级管理", description = "积分等级管理接口")
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
     * 根据ID删除积分等级（逻辑删除）
     *
     * @param id 积分等级ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除积分等级", notes = "逻辑删除积分等级")
    public Result removeById(@PathVariable Long id) {
        boolean removeResult = iIntegralGradeService.removeById(id);
        if (removeResult) {
            return Result.success().message("删除积分等级成功");
        } else {
            return Result.error().message("删除积分等级失败");
        }
    }

    /**
     * 保存积分等级
     * <p>
     * 参数校验：
     * - 积分起始值不能为空
     * - 积分结束值不能为空
     * - 借款金额不能为空
     * </p>
     *
     * @param integralGrade 积分等级实体对象
     * @return 保存结果的统一响应
     * @throws BusinessException 参数校验失败时抛出业务异常
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存积分等级", notes = "保存积分等级")
    public Result save(@RequestBody IntegralGrade integralGrade) {
        // 收集所有校验错误信息
        StringBuilder errors = new StringBuilder();
        if (integralGrade.getIntegralStart() == null) {
            errors.append(ResponseEnum.INTEGRAL_START_NULL_ERROR.getMessage()).append("；");
        }
        if (integralGrade.getIntegralEnd() == null) {
            errors.append(ResponseEnum.INTEGRAL_END_NULL_ERROR.getMessage()).append("；");
        }
        if (integralGrade.getBorrowAmount() == null) {
            errors.append(ResponseEnum.BORROW_AMOUNT_NULL_ERROR.getMessage()).append("；");
        }
        // 如果有校验错误，抛出异常
        if (errors.length() > 0) {
            throw new BusinessException(errors.toString());
        }

        boolean saveResult = iIntegralGradeService.save(integralGrade);
        if (saveResult) {
            return Result.success().message("保存积分等级成功");
        } else {
            return Result.error().message("保存积分等级失败");
        }
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
        IntegralGrade integralGrade = iIntegralGradeService.getById(id);
        if (integralGrade != null) {
            return Result.success().data("integralGrade", integralGrade).message("根据 ID 查询积分等级成功");
        } else {
            return Result.error().message("根据 ID 查询积分等级失败");
        }
    }

    /**
     * 根据ID更新积分等级
     *
     * @param integralGrade 积分等级实体对象（需包含ID）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新积分等级", notes = "根据 ID 更新积分等级")
    public Result updateById(@PathVariable Long id, @RequestBody IntegralGrade integralGrade) {
        integralGrade.setId(id); // 确保 id 被设置
        boolean updateResult = iIntegralGradeService.updateById(integralGrade);
        if (updateResult) {
            return Result.success().message("更新积分等级成功");
        } else {
            return Result.error().message("更新积分等级失败");
        }
    }

}


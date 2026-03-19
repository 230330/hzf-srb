package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.IntegralGrade;
import com.hzf.service.core.service.IIntegralGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 积分等级表 前端控制器
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin // 允许跨域请求
@RestController
@RequestMapping("/admin/core/integralGrade")
@Api(tags = "积分等级管理", description = "积分等级管理接口")
public class AdminIntegralGradeController {

    @Resource
    private IIntegralGradeService iIntegralGradeService;


    @GetMapping("/listAll")
    @ApiOperation("查询所有积分等级列表")
    public Result listAll(){
        List<IntegralGrade> list = iIntegralGradeService.list();
        return Result.success().data("list", list).message("查询所有积分等级列表成功"); // 返回成功结果，并添加数据
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除积分等级", notes = "逻辑删除积分等级")
    public Result removeById(@PathVariable Long id){
        boolean removeResult = iIntegralGradeService.removeById(id);
        if(removeResult)
            return Result.success().message("删除积分等级成功");
        else
            return Result.error().message("删除积分等级失败");
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存或更新积分等级", notes = "保存或更新积分等级")
    public Result save(@RequestBody IntegralGrade integralGrade){
        boolean saveResult = iIntegralGradeService.saveOrUpdate(integralGrade);
        if(saveResult)
            return Result.success().message("保存或更新积分等级成功");
        else
            return Result.error().message("保存或更新积分等级失败");
    }

    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询积分等级", notes = "根据 ID 查询积分等级")
    public Result getById(@PathVariable Long id){
        IntegralGrade integralGrade = iIntegralGradeService.getById(id);
        if (integralGrade != null){
            return Result.success().data("integralGrade", integralGrade).message("根据 ID 查询积分等级成功");
        }else {
            return Result.error().message("根据 ID 查询积分等级失败");
        }
    }

    @PutMapping("/updateById")
    @ApiOperation(value = "根据 ID 更新积分等级", notes = "根据 ID 更新积分等级")
    public Result updateById(@RequestBody IntegralGrade integralGrade){
        boolean updateResult = iIntegralGradeService.updateById(integralGrade);
        if(updateResult)
            return Result.success().message("根据 ID 更新积分等级成功");
        else
            return Result.error().message("根据 ID 更新积分等级失败");
    }

}


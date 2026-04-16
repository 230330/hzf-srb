package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.BorrowerAttach;
import com.hzf.service.core.service.IBorrowerAttachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 借款人上传资源 前端控制器
 * <p>
 * 提供借款人上传资源的增删改查接口
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@RestController
@RequestMapping("/web/core/borrowerAttach")
@Api(tags = "借款人上传资源")
@Slf4j
public class BorrowerAttachController {

    @Resource
    private IBorrowerAttachService iBorrowerAttachService;

    @GetMapping("/listAll")
    @ApiOperation("查询所有借款人上传资源列表")
    public Result listAll() {
        List<BorrowerAttach> list = iBorrowerAttachService.list();
        return Result.success().data("list", list).message("查询所有借款人上传资源列表成功");
    }

    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询借款人上传资源", notes = "根据 ID 查询借款人上传资源")
    public Result getById(@PathVariable Long id) {
        BorrowerAttach borrowerAttach = iBorrowerAttachService.getBorrowerAttachById(id);
        return Result.success().data("borrowerAttach", borrowerAttach).message("根据 ID 查询借款人上传资源成功");
    }

    @GetMapping("/getByBorrowerId/{borrowerId}")
    @ApiOperation(value = "根据借款人ID查询上传资源", notes = "根据借款人ID查询上传资源")
    public Result getByBorrowerId(@PathVariable Long borrowerId) {
        List<BorrowerAttach> list = iBorrowerAttachService.getBorrowerAttachByBorrowerId(borrowerId);
        return Result.success().data("list", list).message("根据借款人ID查询上传资源成功");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增借款人上传资源", notes = "新增借款人上传资源")
    public Result save(@RequestBody BorrowerAttach borrowerAttach) {
        iBorrowerAttachService.saveBorrowerAttach(borrowerAttach);
        return Result.success().message("新增借款人上传资源成功");
    }

    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新借款人上传资源", notes = "根据ID更新借款人上传资源")
    public Result updateById(@PathVariable Long id, @RequestBody BorrowerAttach borrowerAttach) {
        iBorrowerAttachService.updateBorrowerAttachById(id, borrowerAttach);
        return Result.success().message("更新借款人上传资源成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除借款人上传资源", notes = "根据ID删除借款人上传资源")
    public Result deleteById(@PathVariable Long id) {
        iBorrowerAttachService.removeBorrowerAttachById(id);
        return Result.success().message("删除借款人上传资源成功");
    }
}
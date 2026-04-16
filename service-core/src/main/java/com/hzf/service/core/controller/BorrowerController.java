package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.Borrower;
import com.hzf.service.core.service.IBorrowerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 借款人 前端控制器
 * <p>
 * 提供借款人的增删改查接口，包括：
 * - 查询所有借款人列表
 * - 根据ID查询借款人
 * - 根据用户ID查询借款人
 * - 根据姓名查询借款人
 * - 根据证件号码查询借款人
 * - 新增借款人
 * - 根据ID更新借款人
 * - 根据ID删除借款人（逻辑删除）
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@CrossOrigin
@RestController
@RequestMapping("/web/core/borrower")
@Api(tags = "借款人")
@Slf4j
public class BorrowerController {

    @Resource
    private IBorrowerService iBorrowerService;

    @GetMapping("/listAll")
    @ApiOperation("查询所有借款人列表")
    public Result listAll() {
        List<Borrower> list = iBorrowerService.list();
        return Result.success().data("list", list).message("查询所有借款人列表成功");
    }

    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询借款人", notes = "根据 ID 查询借款人")
    public Result getById(@PathVariable Long id) {
        Borrower borrower = iBorrowerService.getBorrowerById(id);
        return Result.success().data("borrower", borrower).message("根据 ID 查询借款人成功");
    }

    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询借款人", notes = "根据用户ID查询借款人")
    public Result getByUserId(@PathVariable Long userId) {
        List<Borrower> list = iBorrowerService.getBorrowerByUserId(userId);
        return Result.success().data("list", list).message("根据用户ID查询借款人成功");
    }

    @GetMapping("/getByName/{name}")
    @ApiOperation(value = "根据姓名查询借款人", notes = "根据姓名查询借款人")
    public Result getByName(@PathVariable String name) {
        List<Borrower> list = iBorrowerService.getBorrowerByName(name);
        return Result.success().data("list", list).message("根据姓名查询借款人成功");
    }

    @GetMapping("/getByIdCard/{idCard}")
    @ApiOperation(value = "根据证件号码查询借款人", notes = "根据证件号码查询借款人")
    public Result getByIdCard(@PathVariable String idCard) {
        Borrower borrower = iBorrowerService.getBorrowerByIdCard(idCard);
        return Result.success().data("borrower", borrower).message("根据证件号码查询借款人成功");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增借款人", notes = "新增借款人")
    public Result save(@RequestBody Borrower borrower) {
        iBorrowerService.saveBorrower(borrower);
        return Result.success().message("新增借款人成功");
    }

    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新借款人", notes = "根据ID更新借款人")
    public Result updateById(@PathVariable Long id, @RequestBody Borrower borrower) {
        iBorrowerService.updateBorrowerById(id, borrower);
        return Result.success().message("更新借款人成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除借款人", notes = "根据ID删除借款人")
    public Result deleteById(@PathVariable Long id) {
        iBorrowerService.removeBorrowerById(id);
        return Result.success().message("删除借款人成功");
    }
}

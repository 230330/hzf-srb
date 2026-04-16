package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.BorrowInfo;
import com.hzf.service.core.service.IBorrowInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 借款信息 前端控制器
 * <p>
 * 提供借款信息的查询接口，包括：
 * - 查询所有借款信息列表
 * - 根据借款用户ID查询借款信息
 * - 根据证件号码查询借款信息
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
@RequestMapping("/web/core/borrowInfo")
@Api(tags = "借款信息")
@Slf4j
public class BorrowInfoController {

    /**
     * 借款信息服务接口
     */
    @Resource
    private IBorrowInfoService iBorrowInfoService;

    /**
     * 查询所有借款信息列表
     *
     * @return 包含所有借款信息列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有借款信息列表")
    public Result listAll() {
        List<BorrowInfo> list = iBorrowInfoService.list();
        return Result.success().data("list", list).message("查询所有借款信息成功");
    }

    /**
     * 根据借款用户ID查询借款信息
     *
     * @param userId 借款用户ID
     * @return 包含借款信息的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据借款用户ID查询借款信息", notes = "根据借款用户ID查询借款信息")
    public Result getByUserId(@PathVariable Long userId) {
        List<BorrowInfo> list = iBorrowInfoService.getBorrowInfoByUserId(userId);
        return Result.success().data("list", list).message("查询借款用户信息成功");
    }

    /**
     * 根据证件号码查询借款信息
     *
     * @param idCard 借款用户身份证号码
     * @return 包含借款信息的统一响应结果
     */
    @GetMapping("/getByIdCard/{idCard}")
    @ApiOperation(value = "根据证件号码查询借款信息", notes = "根据证件号码查询借款信息")
    public Result getByIdCard(@PathVariable String idCard) {
        List<BorrowInfo> list = iBorrowInfoService.getBorrowInfoByIdCard(idCard);
        return Result.success().data("list", list).message("查询借款用户信息成功");
    }

    /**
     * 新增借款信息
     *
     * @param borrowInfo 借款信息实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增借款信息", notes = "新增借款信息")
    public Result save(@RequestBody BorrowInfo borrowInfo) {
        iBorrowInfoService.saveBorrowInfo(borrowInfo);
        return Result.success().message("新增借款信息成功");
    }

    /**
     * 根据ID更新借款信息
     *
     * @param id         借款信息ID
     * @param borrowInfo 借款信息实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新借款信息", notes = "根据ID更新借款信息")
    public Result updateById(@PathVariable Long id, @RequestBody BorrowInfo borrowInfo) {
        iBorrowInfoService.updateBorrowInfoById(id, borrowInfo);
        return Result.success().message("更新借款信息成功");
    }

    /**
     * 根据ID删除借款信息（逻辑删除）
     *
     * @param id 借款信息ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除借款信息", notes = "根据ID删除借款信息")
    public Result deleteById(@PathVariable Long id) {
        iBorrowInfoService.removeBorrowInfoById(id);
        return Result.success().message("删除借款信息成功");
    }
}


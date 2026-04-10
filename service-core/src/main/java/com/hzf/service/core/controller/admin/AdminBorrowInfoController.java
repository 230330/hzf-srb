package com.hzf.service.core.controller.admin;

import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.BorrowInfo;
import com.hzf.service.core.service.IBorrowInfoService;
import com.hzf.service.core.service.IBorrowerAttachService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * <p>
 * 借款信息表 前端控制器
 *  * <p>
 *  * 提供借款信息的增删改查接口，包括：
 *  * - 查询所有借款信息列表
 *  * - 新增借款信息
 *  * - 根据ID查询借款信息
 *  * - 根据证件号码查询借款信息
 *  * - 根据ID更新借款信息
 *  * - 根据ID删除借款信息（逻辑删除）
 *  * </p>
 * </p>
 * @author hzf
 * @date 2026/4/10
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/core/borrowInfo")
@Api
@Slf4j

public class AdminBorrowInfoController {
    /**
     * 借款人附件服务
     */
    @Resource
    private IBorrowInfoService iBorrowInfoService;

    /**
     * 查询所有借款信息列表
     *
     * @return 包含所有借款信息列表的统一响应结果
     */
    @GetMapping("/getAllBorrowInfo")
    public Result getAllBorrowInfo() {
        List<BorrowInfo> borrowInfoList = iBorrowInfoService.list();
        return Result.success().message("查询所有借款信息成功").data("borrowInfoList", borrowInfoList);
    }

    /**
     * 新增借款信息
     * <p>
     * 参数校验：
     * - 借款用户id不能为空
     * - 借款金额不能为空
     * - 借款期限不能为空
     * - 年化利率不能为空
     * - 还款方式不能为空
     * </p>
     *
     * @param borrowInfo 借款信息实体对象
     * @return 保存结果的统一响应
     * @throws BusinessException 参数校验失败时抛出业务异常
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增借款信息", notes = "新增借款信息")
    public Result saveBorrowInfo(@RequestBody BorrowInfo borrowInfo) {
        StringBuilder errors = new StringBuilder();
        // 收集所有校验错误信息
        if (borrowInfo.getUserId() == null ) {
            errors.append(ResponseEnum.BORROW_USER_ID_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getAmount() == null ) {
            errors.append(ResponseEnum.BORROW_AMOUNT_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getPeriod() == null ) {
            errors.append(ResponseEnum.BORROW_PERIOD_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getBorrowYearRate() == null ) {
            errors.append(ResponseEnum.BORROW_BORROW_YEAR_RATE_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getReturnMethod() == null ) {
            errors.append(ResponseEnum.BORROW_RETURN_METHOD_NULL_ERROR.getMessage()).append("；");
        }
        // 如果有校验错误，抛出异常
        if (errors.length() > 0){
            throw new BusinessException(errors.toString());
        }
        boolean saveResult = iBorrowInfoService.save(borrowInfo);
        if (saveResult) {
            return Result.success().message("新增借款信息成功");
        } else {
            return Result.error().message("新增借款信息失败");
        }
    }

    /**
     * 根据借款用户ID查询借款信息
     *
     * @param userId 借款用户ID
     * @return 包含借款信息的统一响应结果
     */
    @GetMapping("/getBorrowInfoByUserId/{userId}")
    public Result getBorrowInfoByUserId(@PathVariable Long userId) {
        List<BorrowInfo> borrowInfoList = iBorrowInfoService.getBorrowInfoByUserId(userId);
        return Result.success().message("查询借款用户信息成功").data("borrowInfoList", borrowInfoList);
    }

    /***
     * 根据证件号码查询借款信息
     * @param idCard 借款用户身份证号码
     * @return 包含借款信息的统一响应结果
     */
    @GetMapping("/getBorrowInfoByIdCard/{idCard}")
    public Result getBorrowInfoByIdCard(@PathVariable String idCard) {
        List<BorrowInfo> borrowInfoList = iBorrowInfoService.getBorrowInfoByIdCard(idCard);
        return Result.success().message("查询借款用户信息成功").data("borrowInfoList", borrowInfoList);
    }


    /**  根据ID更新借款信息
     * @param borrowInfo 借款信息实体对象
     * @return 更新结果的统一响应
    */
    @PutMapping("/update")
    public Result updateBorrowInfo(@RequestBody BorrowInfo borrowInfo) {
        boolean updateResult = iBorrowInfoService.updateById(borrowInfo);
        if (updateResult) {
            return Result.success().message("更新借款信息成功");
        } else {
            return Result.error().message("更新借款信息失败");
        }
    }

    /**
     * 根据ID删除借款信息（逻辑删除）
     *
     * @param id 借款信息ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteBorrowInfo(@PathVariable Long id) {
        boolean deleteResult = iBorrowInfoService.removeById(id);
        if (deleteResult) {
            return Result.success().message("删除借款信息成功");
        } else {
            return Result.error().message("删除借款信息失败");
        }
    }

}

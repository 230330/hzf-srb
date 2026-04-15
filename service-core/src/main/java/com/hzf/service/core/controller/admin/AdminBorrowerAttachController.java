package com.hzf.service.core.controller.admin;

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
 * 借款人上传资源管理 前端控制器
 * <p>
 * 提供借款人上传资源的增删改查接口，包括：
 * - 查询所有借款人上传资源列表
 * - 新增借款人上传资源
 * - 根据ID查询借款人上传资源
 * - 根据借款人ID查询上传资源列表
 * - 根据ID更新借款人上传资源
 * - 根据ID删除借款人上传资源（逻辑删除）
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
@RequestMapping("/admin/core/borrowerAttach")
@Api(tags = "借款人上传资源管理")
@Slf4j
public class AdminBorrowerAttachController {

    /**
     * 借款人上传资源服务接口
     */
    @Resource
    private IBorrowerAttachService iBorrowerAttachService;

    /**
     * 查询所有借款人上传资源列表
     *
     * @return 包含所有借款人上传资源列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有借款人上传资源列表")
    public Result listAll() {
        List<BorrowerAttach> list = iBorrowerAttachService.list();
        return Result.success().data("list", list).message("查询所有借款人上传资源列表成功");
    }

    /**
     * 新增借款人上传资源
     *
     * @param borrowerAttach 借款人上传资源实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增借款人上传资源", notes = "新增借款人上传资源")
    public Result save(@RequestBody BorrowerAttach borrowerAttach) {
        iBorrowerAttachService.saveBorrowerAttach(borrowerAttach);
        return Result.success().message("新增借款人上传资源成功");
    }

    /**
     * 根据ID查询借款人上传资源
     *
     * @param id 借款人上传资源ID
     * @return 包含借款人上传资源信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询借款人上传资源", notes = "根据 ID 查询借款人上传资源")
    public Result getById(@PathVariable Long id) {
        BorrowerAttach borrowerAttach = iBorrowerAttachService.getBorrowerAttachById(id);
        return Result.success().data("borrowerAttach", borrowerAttach).message("根据 ID 查询借款人上传资源成功");
    }

    /**
     * 根据借款人ID查询上传资源列表
     *
     * @param borrowerId 借款人ID
     * @return 包含借款人上传资源列表的统一响应结果
     */
    @GetMapping("/getByBorrowerId/{borrowerId}")
    @ApiOperation(value = "根据借款人ID查询上传资源", notes = "根据借款人ID查询上传资源")
    public Result getByBorrowerId(@PathVariable Long borrowerId) {
        List<BorrowerAttach> list = iBorrowerAttachService.getBorrowerAttachByBorrowerId(borrowerId);
        return Result.success().data("list", list).message("根据借款人ID查询上传资源成功");
    }

    /**
     * 根据ID更新借款人上传资源
     *
     * @param id              借款人上传资源ID
     * @param borrowerAttach  借款人上传资源实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新借款人上传资源", notes = "根据 ID 更新借款人上传资源")
    public Result updateById(@PathVariable Long id, @RequestBody BorrowerAttach borrowerAttach) {
        iBorrowerAttachService.updateBorrowerAttachById(id, borrowerAttach);
        return Result.success().message("更新借款人上传资源成功");
    }

    /**
     * 根据ID删除借款人上传资源（逻辑删除）
     *
     * @param id 借款人上传资源ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除借款人上传资源", notes = "逻辑删除借款人上传资源")
    public Result removeById(@PathVariable Long id) {
        iBorrowerAttachService.removeBorrowerAttachById(id);
        return Result.success().message("删除借款人上传资源成功");
    }
}

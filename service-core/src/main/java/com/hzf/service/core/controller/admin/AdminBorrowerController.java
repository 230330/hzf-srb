package com.hzf.service.core.controller.admin;

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
 * 借款人管理 前端控制器
 * <p>
 * 提供借款人的增删改查接口，包括：
 * - 查询所有借款人列表
 * - 新增借款人
 * - 根据ID查询借款人
 * - 根据用户ID查询借款人
 * - 根据姓名查询借款人
 * - 根据证件号码查询借款人
 * - 根据ID更新借款人
 * - 根据ID删除借款人（逻辑删除）
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
@RequestMapping("/admin/core/borrower")
@Api(tags = "借款人管理")
@Slf4j
public class AdminBorrowerController {

    /**
     * 借款人服务接口
     */
    @Resource
    private IBorrowerService iBorrowerService;

    /**
     * 查询所有借款人列表
     *
     * @return 包含所有借款人列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有借款人列表")
    public Result listAll() {
        List<Borrower> list = iBorrowerService.list();
        return Result.success().data("list", list).message("查询所有借款人列表成功");
    }

    /**
     * 新增借款人
     *
     * @param borrower 借款人实体对象
     * @return 保存结果的统一响应
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增借款人", notes = "新增借款人")
    public Result save(@RequestBody Borrower borrower) {
        iBorrowerService.saveBorrower(borrower);
        return Result.success().message("新增借款人成功");
    }

    /**
     * 根据ID查询借款人
     *
     * @param id 借款人ID
     * @return 包含借款人信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询借款人", notes = "根据 ID 查询借款人")
    public Result getById(@PathVariable Long id) {
        Borrower borrower = iBorrowerService.getBorrowerById(id);
        return Result.success().data("borrower", borrower).message("根据 ID 查询借款人成功");
    }

    /**
     * 根据用户ID查询借款人
     *
     * @param userId 用户ID
     * @return 包含借款人列表的统一响应结果
     */
    @GetMapping("/getByUserId/{userId}")
    @ApiOperation(value = "根据用户ID查询借款人", notes = "根据用户ID查询借款人")
    public Result getByUserId(@PathVariable Long userId) {
        List<Borrower> list = iBorrowerService.getBorrowerByUserId(userId);
        return Result.success().data("list", list).message("根据用户ID查询借款人成功");
    }

    /**
     * 根据姓名查询借款人
     *
     * @param name 借款人姓名
     * @return 包含借款人列表的统一响应结果
     */
    @GetMapping("/getByName/{name}")
    @ApiOperation(value = "根据姓名查询借款人", notes = "根据姓名查询借款人")
    public Result getByName(@PathVariable String name) {
        List<Borrower> list = iBorrowerService.getBorrowerByName(name);
        return Result.success().data("list", list).message("根据姓名查询借款人成功");
    }

    /**
     * 根据证件号码查询借款人
     *
     * @param idCard 身份证号
     * @return 包含借款人信息的统一响应结果
     */
    @GetMapping("/getByIdCard/{idCard}")
    @ApiOperation(value = "根据证件号码查询借款人", notes = "根据证件号码查询借款人")
    public Result getByIdCard(@PathVariable String idCard) {
        Borrower borrower = iBorrowerService.getBorrowerByIdCard(idCard);
        return Result.success().data("borrower", borrower).message("根据证件号码查询借款人成功");
    }

    /**
     * 根据ID更新借款人
     *
     * @param id       借款人ID
     * @param borrower 借款人实体对象（需包含更新字段）
     * @return 更新结果的统一响应
     */
    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据 ID 更新借款人", notes = "根据 ID 更新借款人")
    public Result updateById(@PathVariable Long id, @RequestBody Borrower borrower) {
        iBorrowerService.updateBorrowerById(id, borrower);
        return Result.success().message("更新借款人成功");
    }

    /**
     * 根据ID删除借款人（逻辑删除）
     *
     * @param id 借款人ID
     * @return 删除结果的统一响应
     */
    @DeleteMapping("/removeById/{id}")
    @ApiOperation(value = "根据 ID 删除借款人", notes = "逻辑删除借款人")
    public Result removeById(@PathVariable Long id) {
        iBorrowerService.removeBorrowerById(id);
        return Result.success().message("删除借款人成功");
    }
}

package com.hzf.service.core.controller;

import com.hzf.guigu.common.result.Result;
import com.hzf.service.core.entity.Dict;
import com.hzf.service.core.service.IDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典 前端控制器
 * <p>
 * 提供数据字典的查询接口，包括：
 * - 查询所有数据字典列表
 * - 根据ID查询数据字典
 * - 根据上级ID查询数据字典列表
 * - 根据编码查询数据字典列表
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
@RequestMapping("/web/core/dict")
@Api(tags = "数据字典")
@Slf4j
public class DictController {

    /**
     * 数据字典服务接口
     */
    @Resource
    private IDictService iDictService;

    /**
     * 查询所有数据字典列表
     *
     * @return 包含所有数据字典列表的统一响应结果
     */
    @GetMapping("/listAll")
    @ApiOperation("查询所有数据字典列表")
    public Result listAll() {
        List<Dict> list = iDictService.list();
        return Result.success().data("list", list).message("查询所有数据字典列表成功");
    }

    /**
     * 根据ID查询数据字典
     *
     * @param id 数据字典ID
     * @return 包含数据字典信息的统一响应结果
     */
    @GetMapping("/getById/{id}")
    @ApiOperation(value = "根据 ID 查询数据字典", notes = "根据 ID 查询数据字典")
    public Result getById(@PathVariable Long id) {
        Dict dict = iDictService.getDictById(id);
        return Result.success().data("dict", dict).message("根据 ID 查询数据字典成功");
    }

    /**
     * 根据上级ID查询数据字典列表
     *
     * @param parentId 上级ID
     * @return 包含数据字典列表的统一响应结果
     */
    @GetMapping("/getByParentId/{parentId}")
    @ApiOperation(value = "根据上级ID查询数据字典", notes = "根据上级ID查询数据字典")
    public Result getByParentId(@PathVariable Long parentId) {
        List<Dict> list = iDictService.getDictByParentId(parentId);
        return Result.success().data("list", list).message("根据上级ID查询数据字典成功");
    }

    /**
     * 根据编码查询数据字典列表
     *
     * @param dictCode 字典编码
     * @return 包含数据字典列表的统一响应结果
     */
    @GetMapping("/getByDictCode/{dictCode}")
    @ApiOperation(value = "根据编码查询数据字典", notes = "根据编码查询数据字典")
    public Result getByDictCode(@PathVariable String dictCode) {
        List<Dict> list = iDictService.getDictByDictCode(dictCode);
        return Result.success().data("list", list).message("根据编码查询数据字典成功");
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增数据字典", notes = "新增数据字典")
    public Result save(@RequestBody Dict dict) {
        iDictService.saveDict(dict);
        return Result.success().message("新增数据字典成功");
    }

    @PutMapping("/updateById/{id}")
    @ApiOperation(value = "根据ID更新数据字典", notes = "根据ID更新数据字典")
    public Result updateById(@PathVariable Long id, @RequestBody Dict dict) {
        iDictService.updateDictById(id, dict);
        return Result.success().message("更新数据字典成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除数据字典", notes = "根据ID删除数据字典")
    public Result deleteById(@PathVariable Long id) {
        iDictService.removeDictById(id);
        return Result.success().message("删除数据字典成功");
    }
}

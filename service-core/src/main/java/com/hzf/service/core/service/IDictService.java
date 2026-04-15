package com.hzf.service.core.service;

import com.hzf.service.core.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IDictService extends IService<Dict> {

    /**
     * 保存数据字典（包含参数校验）
     *
     * @param dict 数据字典实体对象
     */
    void saveDict(Dict dict);

    /**
     * 根据ID查询数据字典，不存在则抛出业务异常
     *
     * @param id 数据字典ID
     * @return 数据字典信息
     */
    Dict getDictById(Long id);

    /**
     * 根据上级ID查询数据字典列表
     *
     * @param parentId 上级ID
     * @return 该上级ID下的数据字典列表
     */
    List<Dict> getDictByParentId(Long parentId);

    /**
     * 根据编码查询数据字典列表
     *
     * @param dictCode 字典编码
     * @return 该编码的数据字典列表
     */
    List<Dict> getDictByDictCode(String dictCode);

    /**
     * 根据ID更新数据字典，不存在则抛出业务异常
     *
     * @param id   数据字典ID
     * @param dict 数据字典实体对象（需包含更新字段）
     */
    void updateDictById(Long id, Dict dict);

    /**
     * 根据ID删除数据字典（逻辑删除），不存在则抛出业务异常
     *
     * @param id 数据字典ID
     */
    void removeDictById(Long id);
}

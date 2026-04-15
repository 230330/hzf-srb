package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.Dict;
import com.hzf.service.core.mapper.DictMapper;
import com.hzf.service.core.service.IDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements IDictService {

    /**
     * 保存数据字典（包含参数校验）
     *
     * @param dict 数据字典实体对象
     */
    @Override
    public void saveDict(Dict dict) {
        if (dict.getName() == null || dict.getName().trim().isEmpty()) {
            throw new BusinessException("数据字典名称不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(dict);
        if (!saveResult) {
            throw new BusinessException("保存数据字典失败");
        }
    }

    /**
     * 根据ID查询数据字典，不存在则抛出业务异常
     *
     * @param id 数据字典ID
     * @return 数据字典信息
     */
    @Override
    public Dict getDictById(Long id) {
        Dict dict = this.getById(id);
        if (dict == null) {
            throw new BusinessException("根据 ID 查询数据字典失败");
        }
        return dict;
    }

    /**
     * 根据上级ID查询数据字典列表
     *
     * @param parentId 上级ID
     * @return 该上级ID下的数据字典列表
     */
    @Override
    public List<Dict> getDictByParentId(Long parentId) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        return this.list(queryWrapper);
    }

    /**
     * 根据编码查询数据字典列表
     *
     * @param dictCode 字典编码
     * @return 该编码的数据字典列表
     */
    @Override
    public List<Dict> getDictByDictCode(String dictCode) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_code", dictCode);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新数据字典，不存在则抛出业务异常
     *
     * @param id   数据字典ID
     * @param dict 数据字典实体对象（需包含更新字段）
     */
    @Override
    public void updateDictById(Long id, Dict dict) {
        dict.setId(id);
        boolean updateResult = this.updateById(dict);
        if (!updateResult) {
            throw new BusinessException("更新数据字典失败");
        }
    }

    /**
     * 根据ID删除数据字典（逻辑删除），不存在则抛出业务异常
     *
     * @param id 数据字典ID
     */
    @Override
    public void removeDictById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除数据字典失败");
        }
    }
}

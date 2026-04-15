package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.LendItemReturn;
import com.hzf.service.core.mapper.LendItemReturnMapper;
import com.hzf.service.core.service.ILendItemReturnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标的出借回款记录表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class LendItemReturnServiceImpl extends ServiceImpl<LendItemReturnMapper, LendItemReturn> implements ILendItemReturnService {

    /**
     * 保存标的出借回款记录（包含参数校验）
     *
     * @param lendItemReturn 标的出借回款记录实体对象
     */
    @Override
    public void saveLendItemReturn(LendItemReturn lendItemReturn) {
        if (lendItemReturn.getLendId() == null) {
            throw new BusinessException("标的ID不能为空");
        }
        if (lendItemReturn.getLendItemId() == null) {
            throw new BusinessException("标的项ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(lendItemReturn);
        if (!saveResult) {
            throw new BusinessException("保存标的出借回款记录失败");
        }
    }

    /**
     * 根据ID查询标的出借回款记录，不存在则抛出业务异常
     *
     * @param id 标的出借回款记录ID
     * @return 标的出借回款记录信息
     */
    @Override
    public LendItemReturn getLendItemReturnById(Long id) {
        LendItemReturn lendItemReturn = this.getById(id);
        if (lendItemReturn == null) {
            throw new BusinessException("根据 ID 查询标的出借回款记录失败");
        }
        return lendItemReturn;
    }

    /**
     * 根据标的ID查询出借回款记录列表
     *
     * @param lendId 标的ID
     * @return 该标的的出借回款记录列表
     */
    @Override
    public List<LendItemReturn> getLendItemReturnByLendId(Long lendId) {
        QueryWrapper<LendItemReturn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_id", lendId);
        return this.list(queryWrapper);
    }

    /**
     * 根据标的项ID查询出借回款记录列表
     *
     * @param lendItemId 标的项ID
     * @return 该标的项的出借回款记录列表
     */
    @Override
    public List<LendItemReturn> getLendItemReturnByLendItemId(Long lendItemId) {
        QueryWrapper<LendItemReturn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_item_id", lendItemId);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新标的出借回款记录，不存在则抛出业务异常
     *
     * @param id              标的出借回款记录ID
     * @param lendItemReturn  标的出借回款记录实体对象（需包含更新字段）
     */
    @Override
    public void updateLendItemReturnById(Long id, LendItemReturn lendItemReturn) {
        lendItemReturn.setId(id);
        boolean updateResult = this.updateById(lendItemReturn);
        if (!updateResult) {
            throw new BusinessException("更新标的出借回款记录失败");
        }
    }

    /**
     * 根据ID删除标的出借回款记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 标的出借回款记录ID
     */
    @Override
    public void removeLendItemReturnById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除标的出借回款记录失败");
        }
    }
}

package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.LendItem;
import com.hzf.service.core.mapper.LendItemMapper;
import com.hzf.service.core.service.ILendItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标的出借记录表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class LendItemServiceImpl extends ServiceImpl<LendItemMapper, LendItem> implements ILendItemService {

    /**
     * 保存标的出借记录（包含参数校验）
     *
     * @param lendItem 标的出借记录实体对象
     */
    @Override
    public void saveLendItem(LendItem lendItem) {
        if (lendItem.getLendId() == null) {
            throw new BusinessException("标的ID不能为空");
        }
        if (lendItem.getInvestUserId() == null) {
            throw new BusinessException("投资用户ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(lendItem);
        if (!saveResult) {
            throw new BusinessException("保存标的出借记录失败");
        }
    }

    /**
     * 根据ID查询标的出借记录，不存在则抛出业务异常
     *
     * @param id 标的出借记录ID
     * @return 标的出借记录信息
     */
    @Override
    public LendItem getLendItemById(Long id) {
        LendItem lendItem = this.getById(id);
        if (lendItem == null) {
            throw new BusinessException("根据 ID 查询标的出借记录失败");
        }
        return lendItem;
    }

    /**
     * 根据标的ID查询出借记录列表
     *
     * @param lendId 标的ID
     * @return 该标的的出借记录列表
     */
    @Override
    public List<LendItem> getLendItemByLendId(Long lendId) {
        QueryWrapper<LendItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_id", lendId);
        return this.list(queryWrapper);
    }

    /**
     * 根据投资用户ID查询出借记录列表
     *
     * @param investUserId 投资用户ID
     * @return 该投资用户的出借记录列表
     */
    @Override
    public List<LendItem> getLendItemByInvestUserId(Long investUserId) {
        QueryWrapper<LendItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("invest_user_id", investUserId);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新标的出借记录，不存在则抛出业务异常
     *
     * @param id       标的出借记录ID
     * @param lendItem 标的出借记录实体对象（需包含更新字段）
     */
    @Override
    public void updateLendItemById(Long id, LendItem lendItem) {
        lendItem.setId(id);
        boolean updateResult = this.updateById(lendItem);
        if (!updateResult) {
            throw new BusinessException("更新标的出借记录失败");
        }
    }

    /**
     * 根据ID删除标的出借记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 标的出借记录ID
     */
    @Override
    public void removeLendItemById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除标的出借记录失败");
        }
    }
}

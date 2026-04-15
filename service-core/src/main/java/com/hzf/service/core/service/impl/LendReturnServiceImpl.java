package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.LendReturn;
import com.hzf.service.core.mapper.LendReturnMapper;
import com.hzf.service.core.service.ILendReturnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 还款记录表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class LendReturnServiceImpl extends ServiceImpl<LendReturnMapper, LendReturn> implements ILendReturnService {

    /**
     * 保存还款记录（包含参数校验）
     *
     * @param lendReturn 还款记录实体对象
     */
    @Override
    public void saveLendReturn(LendReturn lendReturn) {
        if (lendReturn.getLendId() == null) {
            throw new BusinessException("标的ID不能为空");
        }
        if (lendReturn.getUserId() == null) {
            throw new BusinessException("借款人用户ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(lendReturn);
        if (!saveResult) {
            throw new BusinessException("保存还款记录失败");
        }
    }

    /**
     * 根据ID查询还款记录，不存在则抛出业务异常
     *
     * @param id 还款记录ID
     * @return 还款记录信息
     */
    @Override
    public LendReturn getLendReturnById(Long id) {
        LendReturn lendReturn = this.getById(id);
        if (lendReturn == null) {
            throw new BusinessException("根据 ID 查询还款记录失败");
        }
        return lendReturn;
    }

    /**
     * 根据标的ID查询还款记录列表
     *
     * @param lendId 标的ID
     * @return 该标的的还款记录列表
     */
    @Override
    public List<LendReturn> getLendReturnByLendId(Long lendId) {
        QueryWrapper<LendReturn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_id", lendId);
        return this.list(queryWrapper);
    }

    /**
     * 根据用户ID查询还款记录列表
     *
     * @param userId 借款人用户ID
     * @return 该用户的还款记录列表
     */
    @Override
    public List<LendReturn> getLendReturnByUserId(Long userId) {
        QueryWrapper<LendReturn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新还款记录，不存在则抛出业务异常
     *
     * @param id         还款记录ID
     * @param lendReturn 还款记录实体对象（需包含更新字段）
     */
    @Override
    public void updateLendReturnById(Long id, LendReturn lendReturn) {
        lendReturn.setId(id);
        boolean updateResult = this.updateById(lendReturn);
        if (!updateResult) {
            throw new BusinessException("更新还款记录失败");
        }
    }

    /**
     * 根据ID删除还款记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 还款记录ID
     */
    @Override
    public void removeLendReturnById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除还款记录失败");
        }
    }
}

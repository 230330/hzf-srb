package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.Lend;
import com.hzf.service.core.mapper.LendMapper;
import com.hzf.service.core.service.ILendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标的准备表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class LendServiceImpl extends ServiceImpl<LendMapper, Lend> implements ILendService {

    /**
     * 保存标的（包含参数校验）
     *
     * @param lend 标的实体对象
     */
    @Override
    public void saveLend(Lend lend) {
        if (lend.getUserId() == null) {
            throw new BusinessException("借款用户ID不能为空");
        }
        if (lend.getAmount() == null) {
            throw new BusinessException("标的金额不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(lend);
        if (!saveResult) {
            throw new BusinessException("保存标的失败");
        }
    }

    /**
     * 根据ID查询标的，不存在则抛出业务异常
     *
     * @param id 标的ID
     * @return 标的信息
     */
    @Override
    public Lend getLendById(Long id) {
        Lend lend = this.getById(id);
        if (lend == null) {
            throw new BusinessException("根据 ID 查询标的失败");
        }
        return lend;
    }

    /**
     * 根据借款用户ID查询标的列表
     *
     * @param userId 借款用户ID
     * @return 该用户的标的列表
     */
    @Override
    public List<Lend> getLendByUserId(Long userId) {
        QueryWrapper<Lend> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据标的编号查询标的信息
     *
     * @param lendNo 标的编号
     * @return 标的信息
     */
    @Override
    public Lend getLendByLendNo(String lendNo) {
        QueryWrapper<Lend> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lend_no", lendNo);
        return this.getOne(queryWrapper);
    }

    /**
     * 根据ID更新标的，不存在则抛出业务异常
     *
     * @param id   标的ID
     * @param lend 标的实体对象（需包含更新字段）
     */
    @Override
    public void updateLendById(Long id, Lend lend) {
        lend.setId(id);
        boolean updateResult = this.updateById(lend);
        if (!updateResult) {
            throw new BusinessException("更新标的失败");
        }
    }

    /**
     * 根据ID删除标的（逻辑删除），不存在则抛出业务异常
     *
     * @param id 标的ID
     */
    @Override
    public void removeLendById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除标的失败");
        }
    }
}

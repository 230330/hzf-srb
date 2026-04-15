package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.BorrowerAttach;
import com.hzf.service.core.mapper.BorrowerAttachMapper;
import com.hzf.service.core.service.IBorrowerAttachService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 借款人上传资源表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class BorrowerAttachServiceImpl extends ServiceImpl<BorrowerAttachMapper, BorrowerAttach> implements IBorrowerAttachService {

    /**
     * 保存借款人上传资源（包含参数校验）
     *
     * @param borrowerAttach 借款人上传资源实体对象
     */
    @Override
    public void saveBorrowerAttach(BorrowerAttach borrowerAttach) {
        if (borrowerAttach.getBorrowerId() == null) {
            throw new BusinessException("借款人ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(borrowerAttach);
        if (!saveResult) {
            throw new BusinessException("保存借款人上传资源失败");
        }
    }

    /**
     * 根据ID查询借款人上传资源，不存在则抛出业务异常
     *
     * @param id 借款人上传资源ID
     * @return 借款人上传资源信息
     */
    @Override
    public BorrowerAttach getBorrowerAttachById(Long id) {
        BorrowerAttach borrowerAttach = this.getById(id);
        if (borrowerAttach == null) {
            throw new BusinessException("根据 ID 查询借款人上传资源失败");
        }
        return borrowerAttach;
    }

    /**
     * 根据借款人ID查询上传资源列表
     *
     * @param borrowerId 借款人ID
     * @return 该借款人的上传资源列表
     */
    @Override
    public List<BorrowerAttach> getBorrowerAttachByBorrowerId(Long borrowerId) {
        QueryWrapper<BorrowerAttach> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("borrower_id", borrowerId);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新借款人上传资源，不存在则抛出业务异常
     *
     * @param id              借款人上传资源ID
     * @param borrowerAttach  借款人上传资源实体对象（需包含更新字段）
     */
    @Override
    public void updateBorrowerAttachById(Long id, BorrowerAttach borrowerAttach) {
        borrowerAttach.setId(id);
        boolean updateResult = this.updateById(borrowerAttach);
        if (!updateResult) {
            throw new BusinessException("更新借款人上传资源失败");
        }
    }

    /**
     * 根据ID删除借款人上传资源（逻辑删除），不存在则抛出业务异常
     *
     * @param id 借款人上传资源ID
     */
    @Override
    public void removeBorrowerAttachById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除借款人上传资源失败");
        }
    }
}

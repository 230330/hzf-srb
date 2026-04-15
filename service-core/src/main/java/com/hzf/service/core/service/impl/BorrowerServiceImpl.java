package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.service.core.entity.Borrower;
import com.hzf.service.core.mapper.BorrowerMapper;
import com.hzf.service.core.service.IBorrowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 借款人 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class BorrowerServiceImpl extends ServiceImpl<BorrowerMapper, Borrower> implements IBorrowerService {

    /**
     * 保存借款人信息（包含参数校验）
     *
     * @param borrower 借款人实体对象
     */
    @Override
    public void saveBorrower(Borrower borrower) {
        // 收集所有校验错误信息
        StringBuilder errors = new StringBuilder();
        if (borrower.getName() == null || borrower.getName().trim().isEmpty()) {
            errors.append(ResponseEnum.NAME_NULL_ERROR.getMessage()).append("；");
        }
        if (borrower.getIdCard() == null || borrower.getIdCard().trim().isEmpty()) {
            errors.append(ResponseEnum.ID_CARD_NULL_ERROR.getMessage()).append("；");
        }
        if (borrower.getMobile() == null || borrower.getMobile().trim().isEmpty()) {
            errors.append(ResponseEnum.MOBILE_NULL_ERROR.getMessage()).append("；");
        }
        // 如果有校验错误，抛出异常
        if (errors.length() > 0) {
            throw new BusinessException(errors.toString());
        }
        // 执行保存
        boolean saveResult = this.save(borrower);
        if (!saveResult) {
            throw new BusinessException("保存借款人信息失败");
        }
    }

    /**
     * 根据ID查询借款人，不存在则抛出业务异常
     *
     * @param id 借款人ID
     * @return 借款人信息
     */
    @Override
    public Borrower getBorrowerById(Long id) {
        Borrower borrower = this.getById(id);
        if (borrower == null) {
            throw new BusinessException("根据 ID 查询借款人失败");
        }
        return borrower;
    }

    /**
     * 根据用户ID查询借款人列表
     *
     * @param userId 用户ID
     * @return 该用户的借款人信息列表
     */
    @Override
    public List<Borrower> getBorrowerByUserId(Long userId) {
        QueryWrapper<Borrower> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据姓名查询借款人列表
     *
     * @param name 借款人姓名
     * @return 该姓名的借款人信息列表
     */
    @Override
    public List<Borrower> getBorrowerByName(String name) {
        QueryWrapper<Borrower> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return this.list(queryWrapper);
    }

    /**
     * 根据身份证号查询借款人信息
     *
     * @param idCard 身份证号
     * @return 借款人信息
     */
    @Override
    public Borrower getBorrowerByIdCard(String idCard) {
        QueryWrapper<Borrower> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_card", idCard);
        return this.getOne(queryWrapper);
    }

    /**
     * 根据ID更新借款人信息，不存在则抛出业务异常
     *
     * @param id       借款人ID
     * @param borrower 借款人实体对象（需包含更新字段）
     */
    @Override
    public void updateBorrowerById(Long id, Borrower borrower) {
        borrower.setId(id);
        boolean updateResult = this.updateById(borrower);
        if (!updateResult) {
            throw new BusinessException("更新借款人信息失败");
        }
    }

    /**
     * 根据ID删除借款人信息（逻辑删除），不存在则抛出业务异常
     *
     * @param id 借款人ID
     */
    @Override
    public void removeBorrowerById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除借款人信息失败");
        }
    }
}

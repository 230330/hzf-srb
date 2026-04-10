package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.service.core.entity.BorrowInfo;
import com.hzf.service.core.mapper.BorrowInfoMapper;
import com.hzf.service.core.service.IBorrowInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 借款信息表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class BorrowInfoServiceImpl extends ServiceImpl<BorrowInfoMapper, BorrowInfo> implements IBorrowInfoService {

    /**
     * 保存借款信息（包含参数校验）
     *
     * @param borrowInfo 借款信息实体对象
     */
    @Override
    public void saveBorrowInfo(BorrowInfo borrowInfo) {
        // 收集所有校验错误信息
        StringBuilder errors = new StringBuilder();
        if (borrowInfo.getUserId() == null) {
            errors.append(ResponseEnum.BORROW_USER_ID_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getAmount() == null) {
            errors.append(ResponseEnum.BORROW_AMOUNT_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getPeriod() == null) {
            errors.append(ResponseEnum.BORROW_PERIOD_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getBorrowYearRate() == null) {
            errors.append(ResponseEnum.BORROW_BORROW_YEAR_RATE_NULL_ERROR.getMessage()).append("；");
        }
        if (borrowInfo.getReturnMethod() == null) {
            errors.append(ResponseEnum.BORROW_RETURN_METHOD_NULL_ERROR.getMessage()).append("；");
        }
        // 如果有校验错误，抛出异常
        if (errors.length() > 0) {
            throw new BusinessException(errors.toString());
        }
        // 执行保存
        boolean saveResult = this.save(borrowInfo);
        if (!saveResult) {
            throw new BusinessException("保存借款信息失败");
        }
    }

    /**
     * 根据借款用户id获取借款信息列表
     *
     * @param userId 借款用户ID
     * @return 该用户的借款信息列表
     */
    @Override
    public List<BorrowInfo> getBorrowInfoByUserId(Long userId) {
        QueryWrapper<BorrowInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据身份证号获取借款信息列表
     *
     * @param idCard 身份证号
     * @return 该身份证号的借款信息列表
     */
    @Override
    public List<BorrowInfo> getBorrowInfoByIdCard(String idCard) {
        QueryWrapper<BorrowInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_card", idCard);
        return this.list(queryWrapper);
    }

    /**
     * 根据id更新借款信息
     *
     * @param id         借款信息ID
     * @param borrowInfo 借款信息实体对象
     */
    @Override
    public void updateBorrowInfoById(Long id, BorrowInfo borrowInfo) {
        borrowInfo.setId(id);
        boolean updateResult = this.updateById(borrowInfo);
        if (!updateResult) {
            throw new BusinessException("更新借款信息失败");
        }
    }

    /**
     * 根据ID删除借款信息（逻辑删除），不存在则抛出业务异常
     *
     * @param id 借款信息ID
     */
    @Override
    public void removeBorrowInfoById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除借款信息失败");
        }
    }
}

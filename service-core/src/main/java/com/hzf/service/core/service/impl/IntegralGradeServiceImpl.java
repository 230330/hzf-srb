package com.hzf.service.core.service.impl;

import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.service.core.entity.IntegralGrade;
import com.hzf.service.core.mapper.IntegralGradeMapper;
import com.hzf.service.core.service.IIntegralGradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 积分等级表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class IntegralGradeServiceImpl extends ServiceImpl<IntegralGradeMapper, IntegralGrade> implements IIntegralGradeService {

    /**
     * 保存积分等级（包含参数校验）
     *
     * @param integralGrade 积分等级实体对象
     */
    @Override
    public void saveIntegralGrade(IntegralGrade integralGrade) {
        // 收集所有校验错误信息
        StringBuilder errors = new StringBuilder();
        if (integralGrade.getIntegralStart() == null) {
            errors.append(ResponseEnum.INTEGRAL_START_NULL_ERROR.getMessage()).append("；");
        }
        if (integralGrade.getIntegralEnd() == null) {
            errors.append(ResponseEnum.INTEGRAL_END_NULL_ERROR.getMessage()).append("；");
        }
        if (integralGrade.getBorrowAmount() == null) {
            errors.append(ResponseEnum.BORROW_AMOUNT_NULL_ERROR.getMessage()).append("；");
        }
        // 如果有校验错误，抛出异常
        if (errors.length() > 0) {
            throw new BusinessException(errors.toString());
        }
        // 执行保存
        boolean saveResult = this.save(integralGrade);
        if (!saveResult) {
            throw new BusinessException("保存积分等级失败");
        }
    }

    /**
     * 根据ID查询积分等级，不存在则抛出业务异常
     *
     * @param id 积分等级ID
     * @return 积分等级信息
     */
    @Override
    public IntegralGrade getIntegralGradeById(Long id) {
        IntegralGrade integralGrade = this.getById(id);
        if (integralGrade == null) {
            throw new BusinessException("根据 ID 查询积分等级失败");
        }
        return integralGrade;
    }

    /**
     * 根据ID更新积分等级，不存在则抛出业务异常
     *
     * @param id            积分等级ID
     * @param integralGrade 积分等级实体对象（需包含更新字段）
     */
    @Override
    public void updateIntegralGradeById(Long id, IntegralGrade integralGrade) {
        integralGrade.setId(id);
        boolean updateResult = this.updateById(integralGrade);
        if (!updateResult) {
            throw new BusinessException("更新积分等级失败");
        }
    }

    /**
     * 根据ID删除积分等级（逻辑删除），不存在则抛出业务异常
     *
     * @param id 积分等级ID
     */
    @Override
    public void removeIntegralGradeById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除积分等级失败");
        }
    }
}

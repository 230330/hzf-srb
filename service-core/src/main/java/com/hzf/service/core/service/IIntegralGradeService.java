package com.hzf.service.core.service;

import com.hzf.service.core.entity.IntegralGrade;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 积分等级表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IIntegralGradeService extends IService<IntegralGrade> {

    /**
     * 保存积分等级（包含参数校验）
     *
     * @param integralGrade 积分等级实体对象
     */
    void saveIntegralGrade(IntegralGrade integralGrade);

    /**
     * 根据ID查询积分等级，不存在则抛出业务异常
     *
     * @param id 积分等级ID
     * @return 积分等级信息
     */
    IntegralGrade getIntegralGradeById(Long id);

    /**
     * 根据ID更新积分等级，不存在则抛出业务异常
     *
     * @param id            积分等级ID
     * @param integralGrade 积分等级实体对象（需包含更新字段）
     */
    void updateIntegralGradeById(Long id, IntegralGrade integralGrade);

    /**
     * 根据ID删除积分等级（逻辑删除），不存在则抛出业务异常
     *
     * @param id 积分等级ID
     */
    void removeIntegralGradeById(Long id);
}

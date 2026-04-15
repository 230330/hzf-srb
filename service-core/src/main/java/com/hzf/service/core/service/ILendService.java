package com.hzf.service.core.service;

import com.hzf.service.core.entity.Lend;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标的准备表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface ILendService extends IService<Lend> {

    /**
     * 保存标的（包含参数校验）
     *
     * @param lend 标的实体对象
     */
    void saveLend(Lend lend);

    /**
     * 根据ID查询标的，不存在则抛出业务异常
     *
     * @param id 标的ID
     * @return 标的信息
     */
    Lend getLendById(Long id);

    /**
     * 根据借款用户ID查询标的列表
     *
     * @param userId 借款用户ID
     * @return 该用户的标的列表
     */
    List<Lend> getLendByUserId(Long userId);

    /**
     * 根据标的编号查询标的信息
     *
     * @param lendNo 标的编号
     * @return 标的信息
     */
    Lend getLendByLendNo(String lendNo);

    /**
     * 根据ID更新标的，不存在则抛出业务异常
     *
     * @param id   标的ID
     * @param lend 标的实体对象（需包含更新字段）
     */
    void updateLendById(Long id, Lend lend);

    /**
     * 根据ID删除标的（逻辑删除），不存在则抛出业务异常
     *
     * @param id 标的ID
     */
    void removeLendById(Long id);
}

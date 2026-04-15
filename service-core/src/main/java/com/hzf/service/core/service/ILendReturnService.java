package com.hzf.service.core.service;

import com.hzf.service.core.entity.LendReturn;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 还款记录表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface ILendReturnService extends IService<LendReturn> {

    /**
     * 保存还款记录（包含参数校验）
     *
     * @param lendReturn 还款记录实体对象
     */
    void saveLendReturn(LendReturn lendReturn);

    /**
     * 根据ID查询还款记录，不存在则抛出业务异常
     *
     * @param id 还款记录ID
     * @return 还款记录信息
     */
    LendReturn getLendReturnById(Long id);

    /**
     * 根据标的ID查询还款记录列表
     *
     * @param lendId 标的ID
     * @return 该标的的还款记录列表
     */
    List<LendReturn> getLendReturnByLendId(Long lendId);

    /**
     * 根据用户ID查询还款记录列表
     *
     * @param userId 借款人用户ID
     * @return 该用户的还款记录列表
     */
    List<LendReturn> getLendReturnByUserId(Long userId);

    /**
     * 根据ID更新还款记录，不存在则抛出业务异常
     *
     * @param id         还款记录ID
     * @param lendReturn 还款记录实体对象（需包含更新字段）
     */
    void updateLendReturnById(Long id, LendReturn lendReturn);

    /**
     * 根据ID删除还款记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 还款记录ID
     */
    void removeLendReturnById(Long id);
}

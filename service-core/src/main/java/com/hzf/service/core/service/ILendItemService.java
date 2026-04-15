package com.hzf.service.core.service;

import com.hzf.service.core.entity.LendItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标的出借记录表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface ILendItemService extends IService<LendItem> {

    /**
     * 保存标的出借记录（包含参数校验）
     *
     * @param lendItem 标的出借记录实体对象
     */
    void saveLendItem(LendItem lendItem);

    /**
     * 根据ID查询标的出借记录，不存在则抛出业务异常
     *
     * @param id 标的出借记录ID
     * @return 标的出借记录信息
     */
    LendItem getLendItemById(Long id);

    /**
     * 根据标的ID查询出借记录列表
     *
     * @param lendId 标的ID
     * @return 该标的的出借记录列表
     */
    List<LendItem> getLendItemByLendId(Long lendId);

    /**
     * 根据投资用户ID查询出借记录列表
     *
     * @param investUserId 投资用户ID
     * @return 该投资用户的出借记录列表
     */
    List<LendItem> getLendItemByInvestUserId(Long investUserId);

    /**
     * 根据ID更新标的出借记录，不存在则抛出业务异常
     *
     * @param id       标的出借记录ID
     * @param lendItem 标的出借记录实体对象（需包含更新字段）
     */
    void updateLendItemById(Long id, LendItem lendItem);

    /**
     * 根据ID删除标的出借记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 标的出借记录ID
     */
    void removeLendItemById(Long id);
}

package com.hzf.service.core.service;

import com.hzf.service.core.entity.LendItemReturn;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标的出借回款记录表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface ILendItemReturnService extends IService<LendItemReturn> {

    /**
     * 保存标的出借回款记录（包含参数校验）
     *
     * @param lendItemReturn 标的出借回款记录实体对象
     */
    void saveLendItemReturn(LendItemReturn lendItemReturn);

    /**
     * 根据ID查询标的出借回款记录，不存在则抛出业务异常
     *
     * @param id 标的出借回款记录ID
     * @return 标的出借回款记录信息
     */
    LendItemReturn getLendItemReturnById(Long id);

    /**
     * 根据标的ID查询出借回款记录列表
     *
     * @param lendId 标的ID
     * @return 该标的的出借回款记录列表
     */
    List<LendItemReturn> getLendItemReturnByLendId(Long lendId);

    /**
     * 根据标的项ID查询出借回款记录列表
     *
     * @param lendItemId 标的项ID
     * @return 该标的项的出借回款记录列表
     */
    List<LendItemReturn> getLendItemReturnByLendItemId(Long lendItemId);

    /**
     * 根据ID更新标的出借回款记录，不存在则抛出业务异常
     *
     * @param id              标的出借回款记录ID
     * @param lendItemReturn  标的出借回款记录实体对象（需包含更新字段）
     */
    void updateLendItemReturnById(Long id, LendItemReturn lendItemReturn);

    /**
     * 根据ID删除标的出借回款记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 标的出借回款记录ID
     */
    void removeLendItemReturnById(Long id);
}

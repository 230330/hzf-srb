package com.hzf.service.core.service;

import com.hzf.service.core.entity.BorrowerAttach;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 借款人上传资源表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IBorrowerAttachService extends IService<BorrowerAttach> {

    /**
     * 保存借款人上传资源（包含参数校验）
     *
     * @param borrowerAttach 借款人上传资源实体对象
     */
    void saveBorrowerAttach(BorrowerAttach borrowerAttach);

    /**
     * 根据ID查询借款人上传资源，不存在则抛出业务异常
     *
     * @param id 借款人上传资源ID
     * @return 借款人上传资源信息
     */
    BorrowerAttach getBorrowerAttachById(Long id);

    /**
     * 根据借款人ID查询上传资源列表
     *
     * @param borrowerId 借款人ID
     * @return 该借款人的上传资源列表
     */
    List<BorrowerAttach> getBorrowerAttachByBorrowerId(Long borrowerId);

    /**
     * 根据ID更新借款人上传资源，不存在则抛出业务异常
     *
     * @param id              借款人上传资源ID
     * @param borrowerAttach  借款人上传资源实体对象（需包含更新字段）
     */
    void updateBorrowerAttachById(Long id, BorrowerAttach borrowerAttach);

    /**
     * 根据ID删除借款人上传资源（逻辑删除），不存在则抛出业务异常
     *
     * @param id 借款人上传资源ID
     */
    void removeBorrowerAttachById(Long id);
}

package com.hzf.service.core.service;

import com.hzf.service.core.entity.BorrowInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 借款信息表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IBorrowInfoService extends IService<BorrowInfo> {

    /**
     * 保存借款信息（包含参数校验）
     *
     * @param borrowInfo 借款信息实体对象
     */
    void saveBorrowInfo(BorrowInfo borrowInfo);

    /**
     * 根据用户id获取借款信息列表
     *
     * @param userId 用户ID
     * @return 借款信息列表
     */
    List<BorrowInfo> getBorrowInfoByUserId(Long userId);

    /**
     * 根据身份证号获取借款信息列表
     *
     * @param idCard 身份证号
     * @return 借款信息列表
     */
    List<BorrowInfo> getBorrowInfoByIdCard(String idCard);

    /**
     * 根据ID更新借款信息，不存在则抛出业务异常
     *
     * @param id         借款信息ID
     * @param borrowInfo 借款信息实体对象（需包含更新字段）
     */
    void updateBorrowInfoById(Long id, BorrowInfo borrowInfo);

    /**
     * 根据ID删除借款信息（逻辑删除），不存在则抛出业务异常
     *
     * @param id 借款信息ID
     */
    void removeBorrowInfoById(Long id);
}

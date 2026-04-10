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
}

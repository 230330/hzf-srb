package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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


}

package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.TransFlow;
import com.hzf.service.core.mapper.TransFlowMapper;
import com.hzf.service.core.service.ITransFlowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 交易流水表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class TransFlowServiceImpl extends ServiceImpl<TransFlowMapper, TransFlow> implements ITransFlowService {

    /**
     * 保存交易流水（包含参数校验）
     *
     * @param transFlow 交易流水实体对象
     */
    @Override
    public void saveTransFlow(TransFlow transFlow) {
        if (transFlow.getUserId() == null) {
            throw new BusinessException("用户ID不能为空");
        }
        if (transFlow.getTransNo() == null || transFlow.getTransNo().trim().isEmpty()) {
            throw new BusinessException("交易单号不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(transFlow);
        if (!saveResult) {
            throw new BusinessException("保存交易流水失败");
        }
    }

    /**
     * 根据ID查询交易流水，不存在则抛出业务异常
     *
     * @param id 交易流水ID
     * @return 交易流水信息
     */
    @Override
    public TransFlow getTransFlowById(Long id) {
        TransFlow transFlow = this.getById(id);
        if (transFlow == null) {
            throw new BusinessException("根据 ID 查询交易流水失败");
        }
        return transFlow;
    }

    /**
     * 根据用户ID查询交易流水列表
     *
     * @param userId 用户ID
     * @return 该用户的交易流水列表
     */
    @Override
    public List<TransFlow> getTransFlowByUserId(Long userId) {
        QueryWrapper<TransFlow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据交易单号查询交易流水
     *
     * @param transNo 交易单号
     * @return 交易流水信息
     */
    @Override
    public TransFlow getTransFlowByTransNo(String transNo) {
        QueryWrapper<TransFlow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("trans_no", transNo);
        return this.getOne(queryWrapper);
    }

    /**
     * 根据ID更新交易流水，不存在则抛出业务异常
     *
     * @param id        交易流水ID
     * @param transFlow 交易流水实体对象（需包含更新字段）
     */
    @Override
    public void updateTransFlowById(Long id, TransFlow transFlow) {
        transFlow.setId(id);
        boolean updateResult = this.updateById(transFlow);
        if (!updateResult) {
            throw new BusinessException("更新交易流水失败");
        }
    }

    /**
     * 根据ID删除交易流水（逻辑删除），不存在则抛出业务异常
     *
     * @param id 交易流水ID
     */
    @Override
    public void removeTransFlowById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除交易流水失败");
        }
    }
}

package com.hzf.service.core.service;

import com.hzf.service.core.entity.TransFlow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 交易流水表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface ITransFlowService extends IService<TransFlow> {

    /**
     * 保存交易流水（包含参数校验）
     *
     * @param transFlow 交易流水实体对象
     */
    void saveTransFlow(TransFlow transFlow);

    /**
     * 根据ID查询交易流水，不存在则抛出业务异常
     *
     * @param id 交易流水ID
     * @return 交易流水信息
     */
    TransFlow getTransFlowById(Long id);

    /**
     * 根据用户ID查询交易流水列表
     *
     * @param userId 用户ID
     * @return 该用户的交易流水列表
     */
    List<TransFlow> getTransFlowByUserId(Long userId);

    /**
     * 根据交易单号查询交易流水
     *
     * @param transNo 交易单号
     * @return 交易流水信息
     */
    TransFlow getTransFlowByTransNo(String transNo);

    /**
     * 根据ID更新交易流水，不存在则抛出业务异常
     *
     * @param id        交易流水ID
     * @param transFlow 交易流水实体对象（需包含更新字段）
     */
    void updateTransFlowById(Long id, TransFlow transFlow);

    /**
     * 根据ID删除交易流水（逻辑删除），不存在则抛出业务异常
     *
     * @param id 交易流水ID
     */
    void removeTransFlowById(Long id);
}

package com.hzf.service.core.service;

import com.hzf.service.core.entity.UserIntegral;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户积分记录表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IUserIntegralService extends IService<UserIntegral> {

    /**
     * 保存用户积分记录（包含参数校验）
     *
     * @param userIntegral 用户积分记录实体对象
     */
    void saveUserIntegral(UserIntegral userIntegral);

    /**
     * 根据ID查询用户积分记录，不存在则抛出业务异常
     *
     * @param id 用户积分记录ID
     * @return 用户积分记录信息
     */
    UserIntegral getUserIntegralById(Long id);

    /**
     * 根据用户ID查询积分记录列表
     *
     * @param userId 用户ID
     * @return 该用户的积分记录列表
     */
    List<UserIntegral> getUserIntegralByUserId(Long userId);

    /**
     * 根据ID更新用户积分记录，不存在则抛出业务异常
     *
     * @param id           用户积分记录ID
     * @param userIntegral 用户积分记录实体对象（需包含更新字段）
     */
    void updateUserIntegralById(Long id, UserIntegral userIntegral);

    /**
     * 根据ID删除用户积分记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户积分记录ID
     */
    void removeUserIntegralById(Long id);
}

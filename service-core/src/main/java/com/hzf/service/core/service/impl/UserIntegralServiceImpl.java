package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.UserIntegral;
import com.hzf.service.core.mapper.UserIntegralMapper;
import com.hzf.service.core.service.IUserIntegralService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户积分记录表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class UserIntegralServiceImpl extends ServiceImpl<UserIntegralMapper, UserIntegral> implements IUserIntegralService {

    /**
     * 保存用户积分记录（包含参数校验）
     *
     * @param userIntegral 用户积分记录实体对象
     */
    @Override
    public void saveUserIntegral(UserIntegral userIntegral) {
        if (userIntegral.getUserId() == null) {
            throw new BusinessException("用户ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(userIntegral);
        if (!saveResult) {
            throw new BusinessException("保存用户积分记录失败");
        }
    }

    /**
     * 根据ID查询用户积分记录，不存在则抛出业务异常
     *
     * @param id 用户积分记录ID
     * @return 用户积分记录信息
     */
    @Override
    public UserIntegral getUserIntegralById(Long id) {
        UserIntegral userIntegral = this.getById(id);
        if (userIntegral == null) {
            throw new BusinessException("根据 ID 查询用户积分记录失败");
        }
        return userIntegral;
    }

    /**
     * 根据用户ID查询积分记录列表
     *
     * @param userId 用户ID
     * @return 该用户的积分记录列表
     */
    @Override
    public List<UserIntegral> getUserIntegralByUserId(Long userId) {
        QueryWrapper<UserIntegral> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新用户积分记录，不存在则抛出业务异常
     *
     * @param id           用户积分记录ID
     * @param userIntegral 用户积分记录实体对象（需包含更新字段）
     */
    @Override
    public void updateUserIntegralById(Long id, UserIntegral userIntegral) {
        userIntegral.setId(id);
        boolean updateResult = this.updateById(userIntegral);
        if (!updateResult) {
            throw new BusinessException("更新用户积分记录失败");
        }
    }

    /**
     * 根据ID删除用户积分记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户积分记录ID
     */
    @Override
    public void removeUserIntegralById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除用户积分记录失败");
        }
    }
}

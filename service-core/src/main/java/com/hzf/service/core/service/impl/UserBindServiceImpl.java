package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.UserBind;
import com.hzf.service.core.mapper.UserBindMapper;
import com.hzf.service.core.service.IUserBindService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户绑定表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class UserBindServiceImpl extends ServiceImpl<UserBindMapper, UserBind> implements IUserBindService {

    /**
     * 保存用户绑定（包含参数校验）
     *
     * @param userBind 用户绑定实体对象
     */
    @Override
    public void saveUserBind(UserBind userBind) {
        if (userBind.getUserId() == null) {
            throw new BusinessException("用户ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(userBind);
        if (!saveResult) {
            throw new BusinessException("保存用户绑定失败");
        }
    }

    /**
     * 根据ID查询用户绑定，不存在则抛出业务异常
     *
     * @param id 用户绑定ID
     * @return 用户绑定信息
     */
    @Override
    public UserBind getUserBindById(Long id) {
        UserBind userBind = this.getById(id);
        if (userBind == null) {
            throw new BusinessException("根据 ID 查询用户绑定失败");
        }
        return userBind;
    }

    /**
     * 根据用户ID查询用户绑定
     *
     * @param userId 用户ID
     * @return 用户绑定信息
     */
    @Override
    public UserBind getUserBindByUserId(Long userId) {
        QueryWrapper<UserBind> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.getOne(queryWrapper);
    }

    /**
     * 根据ID更新用户绑定，不存在则抛出业务异常
     *
     * @param id       用户绑定ID
     * @param userBind 用户绑定实体对象（需包含更新字段）
     */
    @Override
    public void updateUserBindById(Long id, UserBind userBind) {
        userBind.setId(id);
        boolean updateResult = this.updateById(userBind);
        if (!updateResult) {
            throw new BusinessException("更新用户绑定失败");
        }
    }

    /**
     * 根据ID删除用户绑定（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户绑定ID
     */
    @Override
    public void removeUserBindById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除用户绑定失败");
        }
    }
}

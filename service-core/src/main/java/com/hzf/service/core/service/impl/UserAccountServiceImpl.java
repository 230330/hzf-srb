package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.UserAccount;
import com.hzf.service.core.mapper.UserAccountMapper;
import com.hzf.service.core.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

    /**
     * 保存用户账户（包含参数校验）
     *
     * @param userAccount 用户账户实体对象
     */
    @Override
    public void saveUserAccount(UserAccount userAccount) {
        if (userAccount.getUserId() == null) {
            throw new BusinessException("用户ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(userAccount);
        if (!saveResult) {
            throw new BusinessException("保存用户账户失败");
        }
    }

    /**
     * 根据ID查询用户账户，不存在则抛出业务异常
     *
     * @param id 用户账户ID
     * @return 用户账户信息
     */
    @Override
    public UserAccount getUserAccountById(Long id) {
        UserAccount userAccount = this.getById(id);
        if (userAccount == null) {
            throw new BusinessException("根据 ID 查询用户账户失败");
        }
        return userAccount;
    }

    /**
     * 根据用户ID查询用户账户
     *
     * @param userId 用户ID
     * @return 用户账户信息
     */
    @Override
    public UserAccount getUserAccountByUserId(Long userId) {
        QueryWrapper<UserAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.getOne(queryWrapper);
    }

    /**
     * 根据ID更新用户账户，不存在则抛出业务异常
     *
     * @param id          用户账户ID
     * @param userAccount 用户账户实体对象（需包含更新字段）
     */
    @Override
    public void updateUserAccountById(Long id, UserAccount userAccount) {
        userAccount.setId(id);
        boolean updateResult = this.updateById(userAccount);
        if (!updateResult) {
            throw new BusinessException("更新用户账户失败");
        }
    }

    /**
     * 根据ID删除用户账户（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户账户ID
     */
    @Override
    public void removeUserAccountById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除用户账户失败");
        }
    }
}

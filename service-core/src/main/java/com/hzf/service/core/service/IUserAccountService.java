package com.hzf.service.core.service;

import com.hzf.service.core.entity.UserAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户账户 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IUserAccountService extends IService<UserAccount> {

    /**
     * 保存用户账户（包含参数校验）
     *
     * @param userAccount 用户账户实体对象
     */
    void saveUserAccount(UserAccount userAccount);

    /**
     * 根据ID查询用户账户，不存在则抛出业务异常
     *
     * @param id 用户账户ID
     * @return 用户账户信息
     */
    UserAccount getUserAccountById(Long id);

    /**
     * 根据用户ID查询用户账户
     *
     * @param userId 用户ID
     * @return 用户账户信息
     */
    UserAccount getUserAccountByUserId(Long userId);

    /**
     * 根据ID更新用户账户，不存在则抛出业务异常
     *
     * @param id          用户账户ID
     * @param userAccount 用户账户实体对象（需包含更新字段）
     */
    void updateUserAccountById(Long id, UserAccount userAccount);

    /**
     * 根据ID删除用户账户（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户账户ID
     */
    void removeUserAccountById(Long id);
}

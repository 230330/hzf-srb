package com.hzf.service.core.service;

import com.hzf.service.core.entity.UserBind;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户绑定表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IUserBindService extends IService<UserBind> {

    /**
     * 保存用户绑定（包含参数校验）
     *
     * @param userBind 用户绑定实体对象
     */
    void saveUserBind(UserBind userBind);

    /**
     * 根据ID查询用户绑定，不存在则抛出业务异常
     *
     * @param id 用户绑定ID
     * @return 用户绑定信息
     */
    UserBind getUserBindById(Long id);

    /**
     * 根据用户ID查询用户绑定
     *
     * @param userId 用户ID
     * @return 用户绑定信息
     */
    UserBind getUserBindByUserId(Long userId);

    /**
     * 根据ID更新用户绑定，不存在则抛出业务异常
     *
     * @param id       用户绑定ID
     * @param userBind 用户绑定实体对象（需包含更新字段）
     */
    void updateUserBindById(Long id, UserBind userBind);

    /**
     * 根据ID删除用户绑定（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户绑定ID
     */
    void removeUserBindById(Long id);
}

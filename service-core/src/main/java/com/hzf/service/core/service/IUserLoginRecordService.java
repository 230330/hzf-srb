package com.hzf.service.core.service;

import com.hzf.service.core.entity.UserLoginRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户登录记录表 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IUserLoginRecordService extends IService<UserLoginRecord> {

    /**
     * 保存用户登录记录（包含参数校验）
     *
     * @param userLoginRecord 用户登录记录实体对象
     */
    void saveUserLoginRecord(UserLoginRecord userLoginRecord);

    /**
     * 根据ID查询用户登录记录，不存在则抛出业务异常
     *
     * @param id 用户登录记录ID
     * @return 用户登录记录信息
     */
    UserLoginRecord getUserLoginRecordById(Long id);

    /**
     * 根据用户ID查询登录记录列表
     *
     * @param userId 用户ID
     * @return 该用户的登录记录列表
     */
    List<UserLoginRecord> getUserLoginRecordByUserId(Long userId);

    /**
     * 根据ID更新用户登录记录，不存在则抛出业务异常
     *
     * @param id               用户登录记录ID
     * @param userLoginRecord  用户登录记录实体对象（需包含更新字段）
     */
    void updateUserLoginRecordById(Long id, UserLoginRecord userLoginRecord);

    /**
     * 根据ID删除用户登录记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户登录记录ID
     */
    void removeUserLoginRecordById(Long id);
}

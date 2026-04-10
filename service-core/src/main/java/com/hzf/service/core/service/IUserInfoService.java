package com.hzf.service.core.service;

import com.hzf.service.core.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 保存用户信息（包含参数校验）
     *
     * @param userInfo 用户信息实体对象
     */
    void saveUserInfo(UserInfo userInfo);

    /**
     * 根据ID查询用户信息，不存在则抛出业务异常
     *
     * @param id 用户ID
     * @return 用户信息
     */
    UserInfo getUserInfoById(Long id);

    /**
     * 根据姓名查询用户信息列表，不存在则抛出业务异常
     *
     * @param name 用户姓名
     * @return 用户信息列表
     */
    List<UserInfo> listByName(String name);

    /**
     * 根据证件号码查询用户信息，不存在则抛出业务异常
     *
     * @param idCard 身份证号
     * @return 用户信息
     */
    UserInfo getByIdCard(String idCard);

    /**
     * 根据ID更新用户信息，不存在则抛出业务异常
     *
     * @param id       用户ID
     * @param userInfo 用户信息实体对象（需包含更新字段）
     */
    void updateUserInfoById(Long id, UserInfo userInfo);

    /**
     * 根据ID删除用户信息（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户ID
     */
    void removeUserInfoById(Long id);
}

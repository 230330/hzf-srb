package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.service.core.entity.UserInfo;
import com.hzf.service.core.mapper.UserInfoMapper;
import com.hzf.service.core.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    /**
     * 保存用户信息（包含参数校验）
     *
     * @param userInfo 用户信息实体对象
     */
    @Override
    public void saveUserInfo(UserInfo userInfo) {
        // 收集所有校验错误信息
        StringBuilder errors = new StringBuilder();
        if (userInfo.getMobile() == null || userInfo.getMobile().trim().isEmpty()) {
            errors.append(ResponseEnum.MOBILE_NULL_ERROR.getMessage()).append("；");
        }
        if (userInfo.getPassword() == null || userInfo.getPassword().trim().isEmpty()) {
            errors.append(ResponseEnum.PASSWORD_NULL_ERROR.getMessage()).append("；");
        }
        if (userInfo.getName() == null || userInfo.getName().trim().isEmpty()) {
            errors.append(ResponseEnum.NAME_NULL_ERROR.getMessage()).append("；");
        }
        if (userInfo.getIdCard() == null || userInfo.getIdCard().trim().isEmpty()) {
            errors.append(ResponseEnum.ID_CARD_NULL_ERROR.getMessage()).append("；");
        }
        // 如果有校验错误，抛出异常
        if (errors.length() > 0) {
            throw new BusinessException(errors.toString());
        }
        // 执行保存
        this.save(userInfo);
    }

    /**
     * 根据ID查询用户信息，不存在则抛出业务异常
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public UserInfo getUserInfoById(Long id) {
        UserInfo userInfo = this.getById(id);
        if (userInfo == null) {
            throw new BusinessException("根据 ID 查询用户信息失败，用户不存在");
        }
        return userInfo;
    }

    /**
     * 根据姓名查询用户信息列表，不存在则抛出业务异常
     *
     * @param name 用户姓名
     * @return 用户信息列表
     */
    @Override
    public List<UserInfo> listByName(String name) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        List<UserInfo> list = this.list(queryWrapper);
        if (list == null || list.isEmpty()) {
            throw new BusinessException("根据姓名查询用户信息失败，用户不存在");
        }
        return list;
    }

    /**
     * 根据证件号码查询用户信息，不存在则抛出业务异常
     *
     * @param idCard 身份证号
     * @return 用户信息
     */
    @Override
    public UserInfo getByIdCard(String idCard) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_card", idCard);
        UserInfo userInfo = this.getOne(queryWrapper);
        if (userInfo == null) {
            throw new BusinessException("根据证件号码查询用户信息失败，用户不存在");
        }
        return userInfo;
    }

    /**
     * 根据ID更新用户信息，不存在则抛出业务异常
     *
     * @param id       用户ID
     * @param userInfo 用户信息实体对象（需包含更新字段）
     */
    @Override
    public void updateUserInfoById(Long id, UserInfo userInfo) {
        userInfo.setId(id);
        boolean updateResult = this.updateById(userInfo);
        if (!updateResult) {
            throw new BusinessException("更新用户信息失败");
        }
    }

    /**
     * 根据ID删除用户信息（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户ID
     */
    @Override
    public void removeUserInfoById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除用户信息失败");
        }
    }
}

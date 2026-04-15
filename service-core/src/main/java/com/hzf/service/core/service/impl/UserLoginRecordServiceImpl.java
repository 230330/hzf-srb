package com.hzf.service.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzf.guigu.common.exception.BusinessException;
import com.hzf.service.core.entity.UserLoginRecord;
import com.hzf.service.core.mapper.UserLoginRecordMapper;
import com.hzf.service.core.service.IUserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author hzf
 * @since 2026-03-17
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements IUserLoginRecordService {

    /**
     * 保存用户登录记录（包含参数校验）
     *
     * @param userLoginRecord 用户登录记录实体对象
     */
    @Override
    public void saveUserLoginRecord(UserLoginRecord userLoginRecord) {
        if (userLoginRecord.getUserId() == null) {
            throw new BusinessException("用户ID不能为空");
        }
        // 执行保存
        boolean saveResult = this.save(userLoginRecord);
        if (!saveResult) {
            throw new BusinessException("保存用户登录记录失败");
        }
    }

    /**
     * 根据ID查询用户登录记录，不存在则抛出业务异常
     *
     * @param id 用户登录记录ID
     * @return 用户登录记录信息
     */
    @Override
    public UserLoginRecord getUserLoginRecordById(Long id) {
        UserLoginRecord userLoginRecord = this.getById(id);
        if (userLoginRecord == null) {
            throw new BusinessException("根据 ID 查询用户登录记录失败");
        }
        return userLoginRecord;
    }

    /**
     * 根据用户ID查询登录记录列表
     *
     * @param userId 用户ID
     * @return 该用户的登录记录列表
     */
    @Override
    public List<UserLoginRecord> getUserLoginRecordByUserId(Long userId) {
        QueryWrapper<UserLoginRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return this.list(queryWrapper);
    }

    /**
     * 根据ID更新用户登录记录，不存在则抛出业务异常
     *
     * @param id               用户登录记录ID
     * @param userLoginRecord  用户登录记录实体对象（需包含更新字段）
     */
    @Override
    public void updateUserLoginRecordById(Long id, UserLoginRecord userLoginRecord) {
        userLoginRecord.setId(id);
        boolean updateResult = this.updateById(userLoginRecord);
        if (!updateResult) {
            throw new BusinessException("更新用户登录记录失败");
        }
    }

    /**
     * 根据ID删除用户登录记录（逻辑删除），不存在则抛出业务异常
     *
     * @param id 用户登录记录ID
     */
    @Override
    public void removeUserLoginRecordById(Long id) {
        boolean removeResult = this.removeById(id);
        if (!removeResult) {
            throw new BusinessException("删除用户登录记录失败");
        }
    }
}

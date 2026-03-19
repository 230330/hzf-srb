package com.hzf.service.core.service.impl;

import com.hzf.service.core.entity.UserInfo;
import com.hzf.service.core.mapper.UserInfoMapper;
import com.hzf.service.core.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}

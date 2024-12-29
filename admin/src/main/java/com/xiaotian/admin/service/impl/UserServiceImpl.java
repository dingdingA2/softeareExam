package com.xiaotian.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaotian.admin.entity.User;
import com.xiaotian.admin.service.UserService;
import com.xiaotian.admin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 15854
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2024-12-29 13:55:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





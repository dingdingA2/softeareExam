package com.xiaotian.admin.mapper;

import com.xiaotian.admin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 15854
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2024-08-07 20:55:33
* @Entity com.xiaotian.admin.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}





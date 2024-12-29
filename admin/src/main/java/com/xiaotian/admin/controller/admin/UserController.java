package com.xiaotian.admin.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaotian.admin.mapper.UserMapper;
import com.xiaotian.admin.common.Result;
import com.xiaotian.admin.entity.User;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 程序狗没有春天
 * @version 1.00
 * @createTime 2024/8/3 22:52
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping("/save")
    public Result<?> save(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword("123456");
        }
        userMapper.insert(user);
        return Result.success("操作成功");
    }

    @PutMapping
    public Result<?> update(@RequestBody User user) {
        userMapper.updateById(user);
        return Result.success("操作成功");
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           // 默认的页码是1
                           @RequestParam(defaultValue = "10") Integer pageSize, // 默认的每页显示数量是10
                           @RequestParam(required = false) String search) {
        // 创建一个 Page<User> 对象
        Page<User> page = new Page<>(pageNum, pageSize);

        // 创建一个 LambdaQueryWrapper 对象，用于构建查询条件(支持很多种条件查询 )
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();

        // 如果搜索字符串不为空，则添加模糊匹配条件
        if (!"".equals(search)) {
            wrapper.like(User::getNickname, search); // 使用 lambda 表达式来设置模糊匹配条件
        }

        // 使用正确的泛型调用 selectPage 方法
        Page<User> userPage = userMapper.selectPage(page, wrapper);

        // 返回查询结果
        return Result.success(userPage);
    }
    @DeleteMapping("/del/{id}")//传递id
    public Result<?> delete(@PathVariable Integer id) {
        userMapper.deleteById(id);
        return Result.success("删除成功");
    }
    @GetMapping("/dj")
    public Result<?> dj() {
        System.out.println("看看我执行了吗");
        return Result.success("操作成功");
    }

    @GetMapping("/search/{username}")
    public Result<?> search(@PathVariable String username) {
        QueryWrapper<User> qw = new QueryWrapper<>();
//        qw.eq("username", username); // 如果您需要精确匹配
         qw.like("username", username); // 如果您需要模糊匹配

        List<User> users = userMapper.selectList(qw);
        if (users.isEmpty()) {
            return Result.fail("未找到用户");
        }
        return Result.success("成功", users);
    }
    @PostMapping("/login")
    public Result<?> login(@RequestBody User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));
        if (res == null) {
            return Result.fail("用户名或密码错误");
        }
        return Result.success("登录成功");
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        userMapper.insert(user);
        return Result.success("注册成功");
    }
}

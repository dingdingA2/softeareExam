package com.xiaotian.admin.common;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;

/*
 *@author 程序狗没有春天
 *@version
 *@create 2024/5/19 14:37
 */
//@Configuration
//这个@Configuration 注解的意思是 把这些配置依赖加入到springboot容器中管理
public class MybatisPlusConfig {
    /**
     * 创建并配置MybatisPlusInterceptor Bean。
     * 这个方法初始化一个MybatisPlusInterceptor实例，并为其添加一个PaginationInnerInterceptor，
     * 专门用于处理MySQL数据库的分页。这个配置是Mybatis Plus在进行数据库操作时用到的，
     * 它增强了Mybatis的分页功能。
     *
     * @return MybatisPlusInterceptor 返回配置好的MybatisPlusInterceptor实例。
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加MySQL分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
        // 该配置确保了分页插件能够在其他可能添加的插件之后执行，这对于正确处理分页逻辑至关重要。
        return interceptor;
    }

}

package com.example.kirracloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.kirracloud.mapper.order", sqlSessionFactoryRef = "orderSqlSessionFactory")
public class DataSourceConfigForOrder {
    // 将这个对象放入Spring容器中
    @Bean(name = "orderDataSource")
    @Primary
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.druid.order")
    public DataSource getOrderDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "orderSqlSessionFactory")
    // 表示这个数据源是默认数据源
    @Primary
    // @Qualifier表示查找Spring容器中名字为oneDataSource的对象
    public SqlSessionFactory getOrderSqlSessionFactory(@Qualifier("orderDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mapper/order/*.xml"));
        return bean.getObject();
    }

    @Bean("orderSqlSessionTemplate")
    // 表示这个数据源是默认数据源
    @Primary
    public SqlSessionTemplate getOrderSqlSessionTemplate(
            @Qualifier("orderSqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }

    // TransactionManager(事务管理者)
    @Bean(name = "orderTransactionManager")
    @Primary
    public DataSourceTransactionManager getOrderTransactionManager(@Qualifier("orderDataSource") DataSource datasource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(datasource);
        return transactionManager;
    }

    // TransactionTemplate(事务模板)
    @Bean
    @Primary
    public TransactionTemplate getOrderTransactionTemplate(@Qualifier("orderTransactionManager") DataSourceTransactionManager manager) {
        return new TransactionTemplate(manager);
    }
}

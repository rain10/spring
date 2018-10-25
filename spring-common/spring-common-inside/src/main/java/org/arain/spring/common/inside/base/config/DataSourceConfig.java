package org.arain.spring.common.inside.base.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 配置数据源
 * @author arain
 * @date 2018年10月16日 上午10:20:55
 */
@Configuration
@PropertySource(value={"classpath:db.properties"})
public class DataSourceConfig {

	@Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    
    @Bean(destroyMethod="close")
    public DataSource dataSource () {
    	DruidDataSource druidDataSource = new DruidDataSource();
    	druidDataSource.setUrl(url);
    	druidDataSource.setDriverClassName(driverClassName);
    	druidDataSource.setUsername(username);
    	druidDataSource.setPassword(password);
    	druidDataSource.setMaxActive(10);
    	druidDataSource.setMinIdle(5);
    	//监控
    	try {
    		druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        	druidDataSource.setMinEvictableIdleTimeMillis(30000);
        	druidDataSource.setValidationQuery("SELECT 1 FROM DUAL");
        	druidDataSource.setTestWhileIdle(true);
        	druidDataSource.setTestOnBorrow(false);
        	druidDataSource.setTestOnReturn(false);
        	druidDataSource.setPoolPreparedStatements(true);
        	druidDataSource.setMaxOpenPreparedStatements(20);
			druidDataSource.setFilters("stat,wall");
			druidDataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
    }
}

package com.example.wondugallery.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config.datasource
 * @date 2023-10-06
 * @explanation
 */
@Configuration
public class DataSourceConfig {
    private final String jdbcUrl;
    private final String driveClassName;
    private final String userName;
    private final String password;
    private final int minimumIdle;
    private final int maximumPoolSize;
    private final int connectionTimeout;
    private final int idleTimeout;

    public DataSourceConfig(  @Value("${spring.datasource.url}") String jdbcUrl,
                              @Value("${spring.datasource.driver-class-name}") String driveClassName,
                              @Value("${spring.datasource.username}") String userName,
                              @Value("${spring.datasource.password}") String password,
                              @Value("${spring.datasource.hikari.minimum-idle}") int minimumIdle,
                              @Value("${spring.datasource.hikari.maximum-pool-size}") int maximumPoolSize,
                              @Value("${spring.datasource.hikari.connection-timeout}") int connectionTimeout,
                              @Value("${spring.datasource.hikari.idle-timeout}") int idleTimeout) {
        this.jdbcUrl = jdbcUrl;
        this.driveClassName = driveClassName;
        this.userName = userName;
        this.password = password;
        this.minimumIdle = minimumIdle;
        this.maximumPoolSize = maximumPoolSize;
        this.connectionTimeout = connectionTimeout;
        this.idleTimeout = idleTimeout;
    }

    @Bean(name = "mySqlHikariConfig")
    public HikariConfig hikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setDriverClassName(driveClassName);
        hikariConfig.setUsername(userName);
        hikariConfig.setPassword(password);

        // MinumumIdle : 일하지 않는 Connection을 유지하는 설정
        hikariConfig.setMinimumIdle(minimumIdle);
        // MaximumPoolSize : Connection Pool에 유지할 Connection의 수 -> 현재 Pool Size가 10 이라면 idle 상태인 pool은 없음
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        // ConnectionTimeout : Connection을 가져오기 위해 기다리는 시간 Timout 되면 SqlException을 던짐
        hikariConfig.setConnectionTimeout(connectionTimeout);
        // IdleTimeOut : 일하지 않는 Connection Pool을 유지하는 시간
        hikariConfig.setIdleTimeout(idleTimeout);
        return hikariConfig;
    }
}

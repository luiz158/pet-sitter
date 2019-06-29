package com.ps.config;

import com.ps.repos.RequestRepo;
import com.ps.repos.impl.JdbcRequestRepo;
import org.springframework.context.annotation.*;

/**
 * Created by iuliana.cosmina on 3/31/16.
 */
@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(basePackages = "com.ps")
public class RequestRepoConfig {

    @DependsOn("dataSource")
    @Bean
    public RequestRepo anotherRepo(){
        return new JdbcRequestRepo();
    }
}

package com.adobe.devcamp.config;

import com.adobe.devcamp.dao.GenericDao;
import com.adobe.devcamp.service.GenericService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class BeanConfiguration {

    @Bean
    public DataSource dataSource() {
        final MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/javadevcamp");
        dataSource.setUser("root");
        dataSource.setPassword("cristina1998");
        return dataSource;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public GenericDao userDao() throws SQLException {
        return new GenericDao(dataSource());
    }

    @Bean
    public GenericService userService(GenericDao genericDao, ObjectMapper objectMapper) throws SQLException {
        return new GenericService(userDao(), objectMapper());
    }
}

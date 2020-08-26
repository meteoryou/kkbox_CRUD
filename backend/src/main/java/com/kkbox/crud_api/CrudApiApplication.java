package com.kkbox.crud_api;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
@MapperScan("com.kkbox.crud_api.mapper")
public class CrudApiApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(CrudApiApplication.class, args);
    }

}

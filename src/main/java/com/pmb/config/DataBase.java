package com.pmb.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableEncryptableProperties
public class DataBase {
    
    @Bean
    public DataBaseConfig createDatabase(final Environment env) {

        return new DataBaseConfig  (env.getProperty("bdd.url"), env.getProperty("bdd.username"), env.getProperty("database.password"));
    }
}
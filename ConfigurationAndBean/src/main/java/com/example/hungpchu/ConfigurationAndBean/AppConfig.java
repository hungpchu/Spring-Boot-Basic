package com.example.hungpchu.ConfigurationAndBean;

import com.example.hungpchu.ConfigurationAndBean.Database.Database;
import com.example.hungpchu.ConfigurationAndBean.Database.MongoDB;
import com.example.hungpchu.ConfigurationAndBean.Database.MySQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("mongoDB")
    public Database getMongoDB()
    {
        Database mongoDB = new MongoDB();
        mongoDB.setUrl("/hungpchu/mongoDB");
        return mongoDB;
    }

    @Bean("mySQL")
    public Database getMySQL()
    {
        Database mySQL = new MySQL();
        mySQL.setUrl("/hungpchu/mySQL");
        return mySQL;
    }
}

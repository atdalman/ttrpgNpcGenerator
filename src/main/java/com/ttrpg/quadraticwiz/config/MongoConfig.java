package com.ttrpg.quadraticwiz.config;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        try {
            return new SimpleMongoClientDbFactory(new ConnectionString(System.getenv("mongoURI-prod")));
        } catch (NullPointerException e) {
            // TODO Write actual environment detection
            return new SimpleMongoClientDbFactory(new ConnectionString(env.getProperty("spring.data.mongodb.uri")));
        }

    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }
}
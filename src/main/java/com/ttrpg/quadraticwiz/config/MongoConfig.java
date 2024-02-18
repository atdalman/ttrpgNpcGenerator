package com.ttrpg.quadraticwiz.config;

import com.mongodb.ConnectionString;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
@EnableMongoRepositories(basePackages = "com.ttrpg.quadraticwiz.repositories.")
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final Environment env;

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDbFactory() {
        try {
            return new SimpleMongoClientDatabaseFactory(new ConnectionString(System.getenv("mongoURI-prod")));
        } catch (NullPointerException e) {
            // TODO Write actual environment detection
            return new SimpleMongoClientDatabaseFactory(new ConnectionString(env.getProperty("spring.data.mongodb.uri")));
        }

    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

    @Override
    protected String getDatabaseName() {
        return null;
    }
}
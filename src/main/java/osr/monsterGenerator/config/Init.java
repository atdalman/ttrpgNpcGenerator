package osr.monsterGenerator.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Init  {

    Logger logger = LoggerFactory.getLogger(InitializingBean.class);

    @Bean
    public MongoClient mongoClient() {
        MongoClient client = null;
        try {
            client = MongoClients.create("mongodb+srv://npcApp:gE7ZrYcxzEQGmqWs@cluster0-gsx5n.mongodb" +
                    ".net/monster_generator?retryWrites=true&w=majority");
            client.getDatabase("monster_generator");
        } catch(Exception e){
            logger.error("Couldn't connect to mongo", e);
        }

        return client;
    }
}
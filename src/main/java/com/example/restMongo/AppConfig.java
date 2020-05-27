package com.example.restMongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.util.Arrays;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    String user = "javaServiceAccount"; // the user name
    String source = "test"; // the source where the user is defined
    char[] password = { 'W', 'S', '6', 'Q', 'e', '8', '\\', '?', 'j', ']', '6', 'H', '+', 'N', '&', 'H' };

    MongoCredential credential = MongoCredential.createScramSha256Credential(user, source, password);

    public @Bean MongoClient mongoClient() {
        return MongoClients.create(MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress("85.159.212.173", 27017))))
                .credential(credential).applyToSslSettings(builder -> builder.enabled(true)).build());
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "test");
    }
}
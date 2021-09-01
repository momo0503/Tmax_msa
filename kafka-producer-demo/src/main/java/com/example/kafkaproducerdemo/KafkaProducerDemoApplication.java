package com.example.kafkaproducerdemo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerDemoApplication.class, args);
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("quickstart-events-2")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        System.out.println("Doing");
        return args -> {
            template.send("quickstart-events-2", "test");
        };
    }
}
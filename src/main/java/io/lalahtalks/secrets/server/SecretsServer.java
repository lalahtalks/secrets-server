package io.lalahtalks.secrets.server;

import io.lalahtalks.secrets.server.domain.IdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;
import java.util.UUID;

@SpringBootApplication
public class SecretsServer {

    public static void main(String[] args) {
        SpringApplication.run(SecretsServer.class, args);
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public IdGenerator idGenerator() {
        return () -> UUID.randomUUID().toString();
    }

}

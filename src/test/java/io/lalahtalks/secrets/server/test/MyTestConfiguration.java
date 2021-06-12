package io.lalahtalks.secrets.server.test;

import io.lalahtalks.secrets.server.domain.IdGenerator;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.Clock;
import java.time.ZoneId;

import static io.lalahtalks.secrets.server.test.DataInstant.NOW;

@TestConfiguration
public class MyTestConfiguration {

    @Bean
    @Primary
    public Clock clock() {
        return Clock.fixed(NOW, ZoneId.of("UTC"));
    }

    @Bean
    @Primary
    public IdGenerator idGenerator() {
        return Mockito.mock(IdGenerator.class);
    }

}

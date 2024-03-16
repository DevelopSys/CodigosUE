package io.bootify.peliculas.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.bootify.peliculas.domain")
@EnableJpaRepositories("io.bootify.peliculas.repos")
@EnableTransactionManagement
public class DomainConfig {
}

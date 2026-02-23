package io.bootify.my_app.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.bootify.my_app.domain")
@EnableJpaRepositories("io.bootify.my_app.repos")
@EnableTransactionManagement
public class DomainConfig {
}

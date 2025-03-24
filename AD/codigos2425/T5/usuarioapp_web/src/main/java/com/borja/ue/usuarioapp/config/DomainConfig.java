package com.borja.ue.usuarioapp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.borja.ue.usuarioapp.domain")
@EnableJpaRepositories("com.borja.ue.usuarioapp.repos")
@EnableTransactionManagement
public class DomainConfig {
}

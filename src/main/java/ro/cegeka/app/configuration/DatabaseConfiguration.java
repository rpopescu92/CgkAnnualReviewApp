package ro.cegeka.app.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ro.cegeka.app.domain.repository")
@EntityScan(basePackages = "ro.cegeka.app.domain.model")
public class DatabaseConfiguration {
}

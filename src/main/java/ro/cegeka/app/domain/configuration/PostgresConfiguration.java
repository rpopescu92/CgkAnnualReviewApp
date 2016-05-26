package ro.cegeka.app.domain.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by roxana on 25.05.2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = "ro.cegeka.app.domain.repository")
@EntityScan(basePackages = "ro.cegeka.app.domain.model")
public class PostgresConfiguration {

}

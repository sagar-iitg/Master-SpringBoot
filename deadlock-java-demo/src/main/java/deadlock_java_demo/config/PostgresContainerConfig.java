package deadlock_java_demo.config;

import org.springframework.boot.jdbc.autoconfigure.
        JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
public class PostgresContainerConfig {

    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16")
                    .withDatabaseName("lockdb")
                    .withUsername("postgres")
                    .withPassword("postgres");

    static {

        postgres.start();
    }

    @Bean
    JdbcConnectionDetails jdbcConnectionDetails() {

        return new JdbcConnectionDetails() {

            @Override
            public String getUsername() {
                return postgres.getUsername();
            }

            @Override
            public String getPassword() {
                return postgres.getPassword();
            }

            @Override
            public String getJdbcUrl() {
                return postgres.getJdbcUrl();
            }

            @Override
            public String getDriverClassName() {
                return postgres.getDriverClassName();
            }
        };
    }
}
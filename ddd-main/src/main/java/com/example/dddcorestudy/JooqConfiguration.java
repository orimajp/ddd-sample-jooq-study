package com.example.dddcorestudy;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JooqConfiguration {

    private final DataSource dataSource;

    @Bean
    public org.jooq.Configuration configuration() {
        DefaultConfiguration config = new DefaultConfiguration();
        config.set(new DataSourceConnectionProvider(dataSource));
        config.set(SQLDialect.MYSQL_5_7);
        config.settings().setRenderSchema(false);
        config.settings().withRenderFormatted(false);
        config.settings().setExecuteLogging(false);
        return config;
    }

    @Bean
    public DSLContext dsl(org.jooq.Configuration configuration) {
        return new DefaultDSLContext(configuration);
    }

}

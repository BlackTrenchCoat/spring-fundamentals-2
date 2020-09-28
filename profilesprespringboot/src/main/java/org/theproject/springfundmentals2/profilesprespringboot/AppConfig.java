package org.theproject.springfundmentals2.profilesprespringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

@Configuration
@PropertySource("profile.properties")
public class AppConfig {

    @Value("${profile}")
    String profile;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer result =  new PropertySourcesPlaceholderConfigurer();
        return result;
    }

    @Bean
    public ProfileBean profileBean() {
        ProfileBean result = new ProfileBean(profile);
        return result;
    }

    @Bean
    @Profile("prod")
    public DataSource datasource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("sql/schema.sql")
                .addScripts("sql/prod-data.sql")
                .build();
    }

}

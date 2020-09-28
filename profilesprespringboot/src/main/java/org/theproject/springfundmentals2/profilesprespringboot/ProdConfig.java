package org.theproject.springfundmentals2.profilesprespringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("prod")
public class ProdConfig {

    @PostConstruct
    public void setup() {
        System.out.println("Configuring prod profile");

    }
}

package org.theproject.springfundmentals2.profilesprespringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import javax.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class DevConfig {

    @PostConstruct
    public void setup() {
        System.out.println("Configuring dev profile");

    }
}

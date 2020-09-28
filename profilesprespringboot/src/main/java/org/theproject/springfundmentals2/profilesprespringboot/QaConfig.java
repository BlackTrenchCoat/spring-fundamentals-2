package org.theproject.springfundmentals2.profilesprespringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile( "qa" )
public class QaConfig {

    @PostConstruct
    public void setup() {
        System.out.println( "Configuring QA profile" );

    }
}


package com.socialmedia.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: PWA-Annotation notwendig?

/**
 * The entry point of the Spring Boot application
 */
@SpringBootApplication
@Theme(value = "social-media-app")
@PWA(name = "Social Media App", shortName = "social media")
public class SocialMediaApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApplication.class, args);
    }

}

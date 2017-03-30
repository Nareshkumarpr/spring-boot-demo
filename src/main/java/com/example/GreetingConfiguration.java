package com.example;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author 1388162
 */
@Configuration
@ConfigurationProperties(prefix = "message")
@Data
public class GreetingConfiguration {
    private String name;
}

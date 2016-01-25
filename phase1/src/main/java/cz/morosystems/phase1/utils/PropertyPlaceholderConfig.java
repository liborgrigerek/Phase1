package cz.morosystems.phase1.utils;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
 
/**
 * Loads properties from a file called ${APP_ENV}.properties
 * or config.properties if APP_ENV is not set.
 */
@Configuration
@PropertySource("classpath:${APP_ENV:config}.properties")
public class PropertyPlaceholderConfig {
 
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
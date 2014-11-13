package de.flameboard.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Bootstraps the application
 *
 * @author svenklemmer
 * @since 1.0.0
 */
//@SpringApplication <- new annotation which will be released with spring boot 1.2.0 TODO: append
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Bootstrap extends SpringBootServletInitializer {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Bootstrap.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Bootstrap.class);
  }

}

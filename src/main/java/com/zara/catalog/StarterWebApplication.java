package com.zara.catalog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootConfiguration
@EnableAutoConfiguration
@Slf4j
public abstract class StarterWebApplication implements CommandLineRunner {

  @Autowired
  private ApplicationContext appContext;

  @Override
  public void run(String... strings) throws Exception {
    Environment env = appContext.getEnvironment();
    String protocol = "http";
    String port = env.getProperty("server.port");
    log.info("\n--------------------------------------------------------\n\t"
            + "API '{}' is running! \n\t"
            + "Local: \t\t{}://localhost:{}\n\t"
            + "Profile(s): \t{}\n--------------------------------------------------------",
        env.getProperty("spring.application.name"), protocol, port, env.getActiveProfiles());
  }
}

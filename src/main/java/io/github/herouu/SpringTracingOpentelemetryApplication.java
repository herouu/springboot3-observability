package io.github.herouu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringTracingOpentelemetryApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringTracingOpentelemetryApplication.class, args);
  }
}

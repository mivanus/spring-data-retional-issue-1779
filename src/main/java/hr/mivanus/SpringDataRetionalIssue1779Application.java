package hr.mivanus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories(basePackages = { "hr.mivanus.jdbc" })
public class SpringDataRetionalIssue1779Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringDataRetionalIssue1779Application.class, args);
  }

}

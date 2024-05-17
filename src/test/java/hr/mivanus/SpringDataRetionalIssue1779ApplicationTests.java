package hr.mivanus;

import hr.mivanus.jdbc.AaaRepository;
import hr.mivanus.model.Aaa;
import hr.mivanus.model.Bbb;
import hr.mivanus.model.Ccc;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Db2Container;

import java.util.Set;

@SpringBootTest
class SpringDataRetionalIssue1779ApplicationTests {

  @Autowired private JdbcAggregateTemplate template;
  @Autowired private AaaRepository aaaRepository;

  static Db2Container db2 =
    new Db2Container("ibmcom/db2:11.5.0.0").acceptLicense().withUsername("db2inst1").withPassword("Password123").withDatabaseName("TSDB");

  @BeforeAll
  static void beforeAll() {
    db2.start();
  }

  @AfterAll
  static void afterAll() {
    db2.stop();
  }

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", db2::getJdbcUrl);
    registry.add("spring.datasource.username", db2::getUsername);
    registry.add("spring.datasource.password", db2::getPassword);
  }

  @Test
  void testAaaRepository() {
    var ccc = new Ccc();
    ccc.setId(2);
    ccc.setBbbId(1);
    ccc.setName("c");

    var bbb = new Bbb();
    bbb.setId(3);
    bbb.setAaaId(1);
    bbb.setName("b");
    bbb.setCcc(ccc);

    var aaa = new Aaa();
    aaa.setId(4);
    aaa.setName("a");
    aaa.setBbbs(Set.of(bbb));

    template.insert(aaa);

    var saved = aaaRepository.findById(aaa.getId());
    Assertions.assertThat(saved).get().satisfies(a -> {
      Assertions.assertThat(a.getBbbs()).isNotEmpty().allMatch(b -> b.getCcc() != null);
    });
  }

}

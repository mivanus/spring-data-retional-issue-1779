package hr.mivanus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "BBB", schema = "FTEST")
public class Bbb {

  @Id
  @Column("ID")
  private Integer id;

  @Column("AAA_ID") private Integer aaaId;

  @Column("NAME") private String name;

  @Column("BBB_ID") private Ccc ccc;

}

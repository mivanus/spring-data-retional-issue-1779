package hr.mivanus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "CCC", schema = "FTEST")
public class Ccc {

  @Id
  @Column("ID")
  private Integer id;

  @Column("BBB_ID") private Integer bbbId;

  @Column("NAME") private String name;

}

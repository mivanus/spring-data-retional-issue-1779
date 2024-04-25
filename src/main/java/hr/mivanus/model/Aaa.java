package hr.mivanus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "AAA", schema = "FTEST")
public class Aaa {

  @Id
  @Column("ID")
  private Integer id;

  @Column("NAME") private String name;

  @MappedCollection(idColumn = "AAA_ID", keyColumn = "ID") private List<Bbb> bbbs = new ArrayList<>();

}

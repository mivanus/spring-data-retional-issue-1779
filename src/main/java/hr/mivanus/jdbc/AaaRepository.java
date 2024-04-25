package hr.mivanus.jdbc;

import hr.mivanus.model.Aaa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AaaRepository extends CrudRepository<Aaa, Integer> {

}

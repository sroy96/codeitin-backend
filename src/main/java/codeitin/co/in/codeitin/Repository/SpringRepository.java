package codeitin.co.in.codeitin.Repository;

import codeitin.co.in.codeitin.DAO.Spring;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringRepository extends MongoRepository<Spring, String> {
}

package codeitin.co.in.codeitin.Repository;

import codeitin.co.in.codeitin.DAO.About;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends MongoRepository<About,String> {

}

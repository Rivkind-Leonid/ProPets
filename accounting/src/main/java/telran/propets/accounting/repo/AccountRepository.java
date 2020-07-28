package telran.propets.accounting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import telran.propets.accounting.dao.UserProfile;

@Repository
public interface AccountRepository extends MongoRepository<UserProfile, String> {
}

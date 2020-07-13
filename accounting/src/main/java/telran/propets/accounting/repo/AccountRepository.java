package telran.propets.accounting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import telran.propets.accounting.dao.UserProfile;

public interface AccountRepository extends MongoRepository<UserProfile, String> {
}

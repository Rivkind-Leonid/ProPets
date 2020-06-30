package telran.ProPets.accounting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import telran.ProPets.accounting.dao.UserProfile;

public interface AccountRepository extends MongoRepository<UserProfile, String> {
}

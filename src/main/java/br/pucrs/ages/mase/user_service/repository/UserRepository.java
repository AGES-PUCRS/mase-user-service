package br.pucrs.ages.mase.user_service.repository;

import br.pucrs.ages.mase.user_service.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String > {
}

package br.pucrs.ages.mase.user_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.ages.mase.user_service.entity.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}

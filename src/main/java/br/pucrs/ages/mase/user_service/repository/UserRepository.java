package br.pucrs.ages.mase.user_service.repository;

import br.pucrs.ages.mase.user_service.entity.UserEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserEntity, String> {

    public Mono<UserEntity> findAllByName(String name);
}

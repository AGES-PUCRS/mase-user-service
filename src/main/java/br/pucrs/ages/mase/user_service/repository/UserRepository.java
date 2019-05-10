package br.pucrs.ages.mase.user_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.ages.mase.user_service.entity.User;
import br.pucrs.ages.mase.user_service.entity.Volunteer;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Flux<Volunteer> findAllByOccupation(String occupation);
}

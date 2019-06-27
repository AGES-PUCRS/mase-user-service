package br.pucrs.ages.mase.user_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.pucrs.ages.mase.user_service.entity.Volunteer;
import reactor.core.publisher.Flux;

public interface VolunteerRepository extends ReactiveMongoRepository<Volunteer, String> {
	
	 Flux<Volunteer> findAllByOccupation(String occupation);

}

package br.pucrs.ages.mase.user_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.pucrs.ages.mase.user_service.entity.CivilDefenseInstitution;
import reactor.core.publisher.Mono;

@Repository
public interface CivilDefenseInstitutionRepository extends ReactiveMongoRepository<CivilDefenseInstitution, String> {
	
	Mono<Optional<CivilDefenseInstitution>> findOneByName(String name);
	
}

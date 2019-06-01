package br.pucrs.ages.mase.user_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.pucrs.ages.mase.user_service.entity.CivilDefenseOfficial;
import reactor.core.publisher.Flux;

public interface CivilDefenseOfficialRepository extends ReactiveMongoRepository<CivilDefenseOfficial, String> {
	
	Flux<CivilDefenseOfficial> findAllByInstitutionalLink(String institutionalLink);
	
}

package br.pucrs.ages.mase.user_service.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.pucrs.ages.mase.user_service.entity.CivilDefenseOfficial;

public interface CivilDefenseOfficialRepository extends ReactiveMongoRepository<CivilDefenseOfficial, String> {
}

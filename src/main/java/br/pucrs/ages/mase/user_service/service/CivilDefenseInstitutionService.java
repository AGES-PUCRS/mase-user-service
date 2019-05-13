package br.pucrs.ages.mase.user_service.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucrs.ages.mase.user_service.dto.CivilDefenseInstitutionDto;
import br.pucrs.ages.mase.user_service.entity.CivilDefenseInstitution;
import br.pucrs.ages.mase.user_service.repository.CivilDefenseInstitutionRepository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class CivilDefenseInstitutionService {
	
	private CivilDefenseInstitutionRepository civilDefenseInstitutionRepository;
	private ObjectMapper objectMapper;
	
	public CivilDefenseInstitutionService(CivilDefenseInstitutionRepository civilDefenseInstitutionRepository,
			ObjectMapper objectMapper) {
		this.civilDefenseInstitutionRepository = civilDefenseInstitutionRepository;
		this.objectMapper = objectMapper;
	}
	
	public Mono<CivilDefenseInstitutionDto> insert(CivilDefenseInstitutionDto civilDefenseInstitutionDto) {
    	return civilDefenseInstitutionRepository.save(objectMapper.convertValue(civilDefenseInstitutionDto, CivilDefenseInstitution.class))
    			.subscribeOn(Schedulers.elastic())
    			.map(civilDefenseInstitution -> objectMapper.convertValue(civilDefenseInstitution, CivilDefenseInstitutionDto.class));
    }

}

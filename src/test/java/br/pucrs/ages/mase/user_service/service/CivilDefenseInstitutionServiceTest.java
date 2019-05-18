package br.pucrs.ages.mase.user_service.service;

import br.pucrs.ages.mase.user_service.dto.CivilDefenseInstitutionDto;
import br.pucrs.ages.mase.user_service.repository.CivilDefenseInstitutionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CivilDefenseInstitutionServiceTest {

    private final CivilDefenseInstitutionService civilDefenseInstitutionService;
    private final CivilDefenseInstitutionRepository civilDefenseInstitutionRepository;
    private final ObjectMapper objectMapper;

    public CivilDefenseInstitutionServiceTest() {
        civilDefenseInstitutionRepository = mock(CivilDefenseInstitutionRepository.class);
        objectMapper = new ObjectMapper();
        civilDefenseInstitutionService = new CivilDefenseInstitutionService(civilDefenseInstitutionRepository, objectMapper);

    }

    @Test
    public void shouldInsertCivilDefenseInstitution() {
        CivilDefenseInstitutionDto civilDefenseInstitutionDto = EnhancedRandom.random(CivilDefenseInstitutionDto.class);

        when(civilDefenseInstitutionRepository.save(any())).thenAnswer(response -> Mono.just(response.getArgument(0)));

        StepVerifier.create(civilDefenseInstitutionService.insert(civilDefenseInstitutionDto))
                .assertNext(response -> assertEquals(response.getId(), civilDefenseInstitutionDto.getId()))
                .verifyComplete();
    }
}

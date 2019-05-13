package br.pucrs.ages.mase.user_service.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.ages.mase.user_service.dto.CivilDefenseInstitutionDto;
import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.service.CivilDefenseInstitutionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/civil-defense-institution")
public class CivilDefenseInstitutionController {
	
	private CivilDefenseInstitutionService civilDefenseInstitutionService;
	
	@ApiOperation(value = "API para registrar Instituição da Defesa Civil",
			notes = "Faz a inclusão de uma Instituição da Defesa Civil no sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Inclusão de instituição realizada com sucesso", response = UserDto.class),
	})
	@PostMapping
	public Mono<CivilDefenseInstitutionDto> insert(@Valid @RequestBody CivilDefenseInstitutionDto civilDefenseInstitutionDto) {
		return civilDefenseInstitutionService.insert(civilDefenseInstitutionDto);
	}
	
}

package br.pucrs.ages.mase.user_service.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.ages.mase.user_service.dto.CivilDefenseOfficialDto;
import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.dto.VolunteerDto;
import br.pucrs.ages.mase.user_service.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
    private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@ApiOperation(value = "API para registrar usuário não voluntário",
			notes = "Faz a inclusão de um usuário não voluntário no sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Inclusão de usuário realizada com sucesso", response = UserDto.class),
	})
    @PostMapping
    public Mono<UserDto> insert(@Valid @RequestBody UserDto userDto) {
        return userService.insert(userDto);
    }

	@ApiOperation(value = "API para registrar voluntário",
			notes = "Faz a inclusão de um voluntário no sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Inclusão de voluntário realizada com sucesso", response = VolunteerDto.class),
	})
    @PostMapping("/volunteer")
    public Mono<VolunteerDto> insert(@Valid @RequestBody VolunteerDto volunteerDto) {
        return userService.insert(volunteerDto);
    }

	@ApiOperation(value = "API para registrar funcionário da defesa civil",
			notes = "Faz a inclusão de um funcionário da defesa civil no sistema.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Inclusão de funcionário da defesa civil realizada com sucesso", response = VolunteerDto.class),
	})
    @PostMapping("/civil-defense-official")
    public Mono<CivilDefenseOfficialDto> insert(@Valid @RequestBody CivilDefenseOfficialDto civilDefenseOfficialDto) {
        return userService.insert(civilDefenseOfficialDto);
    }
	
	@ApiOperation(value = "API para retornar todos os voluntários de determinada profissão",
			notes = "Retorna todos os voluntários que praticam a profissão informada.")
	@GetMapping("/volunteers/occupation/{occupation}")
	public Flux<VolunteerDto> getAllByOccupation(@PathVariable("occupation") String occupation) {
		return userService.getAllByOccupation(occupation);
	}

}


package br.pucrs.ages.mase.user_service.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.ages.mase.user_service.dto.CivilDefenseOfficialDto;
import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.dto.VolunteerDto;
import br.pucrs.ages.mase.user_service.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
    private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public Flux<UserDto> getAll() {
		return userService.getAll();
	}
    
    @PostMapping
    public Mono<UserDto> insert(@Valid @RequestBody UserDto userDto) {
        return userService.insert(userDto);
    }
    
    @PostMapping("/volunteer")
    public Mono<VolunteerDto> insert(@Valid @RequestBody VolunteerDto volunteerDto) {
        return userService.insert(volunteerDto);
    }
    
    @PostMapping("/civil-defense-official")
    public Mono<CivilDefenseOfficialDto> insert(@Valid @RequestBody CivilDefenseOfficialDto civilDefenseOfficialDto) {
        return userService.insert(civilDefenseOfficialDto);
    }

}


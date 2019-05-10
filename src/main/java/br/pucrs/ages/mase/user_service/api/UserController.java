package br.pucrs.ages.mase.user_service.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.service.UserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
    private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

    @PostMapping
    public Mono<ResponseEntity<UserDto>> insertUser(@Valid @RequestBody UserDto userDto) {
        return userService.insert(userDto)
                .map(ResponseEntity::ok);
    }

}


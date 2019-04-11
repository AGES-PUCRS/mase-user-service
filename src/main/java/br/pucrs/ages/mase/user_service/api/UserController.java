package br.pucrs.ages.mase.user_service.api;

import br.pucrs.ages.mase.user_service.input.UserDto;
import br.pucrs.ages.mase.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Mono<RequestEntity<UserDto>> insertUser(@Valid @RequestBody UserDto userDto) {
        return null;
    }
}

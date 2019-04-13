package br.pucrs.ages.mase.user_service.api;

import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.model.User;
import br.pucrs.ages.mase.user_service.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/")
    public Mono<ResponseEntity<UserDto>> insertUser(@Valid @RequestBody UserDto userDto) {
        return userService.insert(objectMapper.convertValue(userDto, User.class))
                .map(user -> objectMapper.convertValue(user, UserDto.class))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping("/")
    public Mono<ResponseEntity<UserDto>> getUser(@PathVariable String id){
        return userService.
    }
}


package br.pucrs.ages.mase.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.entity.User;
import br.pucrs.ages.mase.user_service.repository.UserRepository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public Mono<UserDto> insert(UserDto userDto) {
        return userRepository.save(objectMapper.convertValue(userDto, User.class))
                .subscribeOn(Schedulers.elastic())
                .map(user -> objectMapper.convertValue(user, UserDto.class));
    }
}

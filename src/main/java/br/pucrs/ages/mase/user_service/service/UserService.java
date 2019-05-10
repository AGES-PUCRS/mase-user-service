package br.pucrs.ages.mase.user_service.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.entity.User;
import br.pucrs.ages.mase.user_service.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserService {

    private UserRepository userRepository;
    private ObjectMapper objectMapper;
    
    public UserService(UserRepository userRepository, ObjectMapper objectMapper) {
    	this.userRepository = userRepository;
    	this.objectMapper = objectMapper;
    }
    
    public Flux<UserDto> getAll() {
    	return userRepository.findAll()
    			.map(user -> objectMapper.convertValue(user, UserDto.class));
    }

    public Mono<UserDto> insert(UserDto userDto) {
        return userRepository.save(objectMapper.convertValue(userDto, User.class))
                .subscribeOn(Schedulers.elastic())
                .map(user -> objectMapper.convertValue(user, UserDto.class));
    }
}

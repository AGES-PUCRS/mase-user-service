package br.pucrs.ages.mase.user_service.service;

import br.pucrs.ages.mase.user_service.input.UserDto;
import br.pucrs.ages.mase.user_service.model.User;
import br.pucrs.ages.mase.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<UserDto> insert(User user) {
        return null;
    }
}

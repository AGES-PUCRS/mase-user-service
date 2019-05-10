package br.pucrs.ages.mase.user_service.service;

import br.pucrs.ages.mase.user_service.entity.UserEntity;
import br.pucrs.ages.mase.user_service.model.User;
import br.pucrs.ages.mase.user_service.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;


    public Mono<User> insert(User user) {

        userRepository.findAllByName("teste");
        return userRepository.save(objectMapper.convertValue(user, UserEntity.class))
                .subscribeOn(Schedulers.elastic())
                .map(userEntity -> objectMapper.convertValue(userEntity, User.class))
                .doOnError(exception -> {
                    throw new RuntimeException(exception);
                });
    }

//    public Mono<User> findById(String userId){
//        return userRepository.findById();
//    }
}

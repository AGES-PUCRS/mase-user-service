package br.pucrs.ages.mase.user_service.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.pucrs.ages.mase.user_service.dto.CivilDefenseOfficialDto;
import br.pucrs.ages.mase.user_service.dto.UserDto;
import br.pucrs.ages.mase.user_service.dto.VolunteerDto;
import br.pucrs.ages.mase.user_service.entity.CivilDefenseOfficial;
import br.pucrs.ages.mase.user_service.entity.User;
import br.pucrs.ages.mase.user_service.entity.Volunteer;
import br.pucrs.ages.mase.user_service.repository.CivilDefenseOfficialRepository;
import br.pucrs.ages.mase.user_service.repository.UserRepository;
import br.pucrs.ages.mase.user_service.repository.VolunteerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final VolunteerRepository volunteerRepository;
    private final CivilDefenseOfficialRepository civilDefenseOfficialRepository;
    private final ObjectMapper objectMapper;
    
    public UserService(UserRepository userRepository, VolunteerRepository volunteerRepository,
    		CivilDefenseOfficialRepository civilDefenseOfficialRepository, ObjectMapper objectMapper) {
    	this.userRepository = userRepository;
    	this.volunteerRepository = volunteerRepository;
    	this.objectMapper = objectMapper;
    	this.civilDefenseOfficialRepository = civilDefenseOfficialRepository;
    }

    public Mono<UserDto> insert(UserDto userDto) {
        return userRepository.save(objectMapper.convertValue(userDto, User.class))
                .subscribeOn(Schedulers.elastic())
                .map(user -> objectMapper.convertValue(user, UserDto.class));
    }
    
    public Mono<VolunteerDto> insert(VolunteerDto volunteerDto) {
        return volunteerRepository.save(objectMapper.convertValue(volunteerDto, Volunteer.class))
                .subscribeOn(Schedulers.elastic())
                .map(volunteer -> objectMapper.convertValue(volunteer, VolunteerDto.class));
    }
    
    public Mono<CivilDefenseOfficialDto> insert(CivilDefenseOfficialDto civilDefenseOfficialDto) {
        return civilDefenseOfficialRepository.save(objectMapper.convertValue(civilDefenseOfficialDto, CivilDefenseOfficial.class))
                .subscribeOn(Schedulers.elastic())
                .map(civilDefenseOfficial -> objectMapper.convertValue(civilDefenseOfficial, CivilDefenseOfficialDto.class));
    }
    
    public Flux<VolunteerDto> getAllByOccupation(String occupation) {
    	return volunteerRepository.findAllByOccupation(occupation)
    			.subscribeOn(Schedulers.elastic())
    			.map(volunteer -> objectMapper.convertValue(volunteer, VolunteerDto.class));
    }
    
    public Flux<CivilDefenseOfficialDto> getAllByInstitutionalLink(String institutionalLink) {
    	return civilDefenseOfficialRepository.findAllByInstitutionalLink(institutionalLink)
    			.map(civilDefenseOfficial -> objectMapper.convertValue(civilDefenseOfficial, CivilDefenseOfficialDto.class));
    }
    
}

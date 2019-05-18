package br.pucrs.ages.mase.user_service.service;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

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
import io.github.benas.randombeans.api.EnhancedRandom;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class UserServiceTest {
	
	private final UserService userService;
	private final UserRepository userRepository;
	private final VolunteerRepository volunteerRepository;
    private final CivilDefenseOfficialRepository civilDefenseOfficialRepository;
    private final ObjectMapper objectMapper;
	
	public UserServiceTest() {
		userRepository = mock(UserRepository.class);
		volunteerRepository = mock(VolunteerRepository.class);
		civilDefenseOfficialRepository = mock(CivilDefenseOfficialRepository.class);
		objectMapper = new ObjectMapper();
		userService = new UserService(userRepository, volunteerRepository, civilDefenseOfficialRepository, objectMapper);
	}
	
	@Test
	public void testInsertUserSuccess() {
		UserDto expected = EnhancedRandom.random(UserDto.class);
		when(userRepository.save(any(User.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));
		StepVerifier.create(userService.insert(expected))
				.assertNext(actual -> assertEquals(expected, actual))
				.verifyComplete();
	}
	
	private void assertEquals(UserDto expected, UserDto actual) {
		Assert.assertEquals(expected.getCpf(), actual.getCpf());
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
		Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getLastName(), actual.getLastName());
		Assert.assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
		Assert.assertEquals(expected.getPhoto(), actual.getPhoto());
	}
	
	@Test
	public void testInsertVolunteerSuccess() {
		VolunteerDto expected = EnhancedRandom.random(VolunteerDto.class);
		when(volunteerRepository.save(any(Volunteer.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));
		StepVerifier.create(userService.insert(expected))
				.assertNext(actual -> assertEquals(expected, actual))
				.verifyComplete();
	}
	
	@Test
	public void testInsertCivilDefenseOfficialSuccess() {
		CivilDefenseOfficialDto expected = EnhancedRandom.random(CivilDefenseOfficialDto.class);
		when(civilDefenseOfficialRepository.save(any(CivilDefenseOfficial.class)))
				.thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));
		StepVerifier.create(userService.insert(expected))
				.assertNext(actual -> assertEquals(expected, actual))
				.verifyComplete();
	}

}

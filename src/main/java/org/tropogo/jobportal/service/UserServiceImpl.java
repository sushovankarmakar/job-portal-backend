package org.tropogo.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.tropogo.jobportal.converter.UserCreationRequestToUserEntityConverter;
import org.tropogo.jobportal.entity.User;
import org.tropogo.jobportal.exchange.UserCreationRequest;
import org.tropogo.jobportal.exchange.UserCreationResponse;
import org.tropogo.jobportal.repository.UserRepository;

import javax.validation.Valid;

import java.util.Objects;

import static org.tropogo.jobportal.constant.ErrorCode.USER_CREATION_IS_NULL;
import static org.tropogo.jobportal.constant.SuccessCode.USER_CREATION_SUCCESS;

@Service
@Validated
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCreationRequestToUserEntityConverter converter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserCreationResponse createUser(@Valid UserCreationRequest request) {
        User user = Objects.requireNonNull(converter.convert(request),
                USER_CREATION_IS_NULL.getMessage());

        userRepository.save(user);

        return UserCreationResponse.builder()
                .message(USER_CREATION_SUCCESS.getMessage())
                .build();
    }
}

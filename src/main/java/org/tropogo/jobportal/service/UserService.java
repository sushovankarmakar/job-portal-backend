package org.tropogo.jobportal.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.tropogo.jobportal.exchange.UserCreationRequest;
import org.tropogo.jobportal.exchange.UserCreationResponse;

import javax.validation.Valid;

@Service
@Validated
public interface UserService {

    UserCreationResponse createUser(@Valid UserCreationRequest request);
}

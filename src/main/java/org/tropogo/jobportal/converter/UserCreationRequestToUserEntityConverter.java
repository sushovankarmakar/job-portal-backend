package org.tropogo.jobportal.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.tropogo.jobportal.entity.User;
import org.tropogo.jobportal.exchange.UserCreationRequest;

@Component
public class UserCreationRequestToUserEntityConverter implements Converter<UserCreationRequest, User> {

    @Override
    public User convert(UserCreationRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .build();
    }
}

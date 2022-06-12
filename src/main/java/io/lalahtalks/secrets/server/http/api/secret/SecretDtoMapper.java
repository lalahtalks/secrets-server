package io.lalahtalks.secrets.server.http.api.secret;

import io.lalahtalks.secrets.client.dto.SecretCreatedDto;
import io.lalahtalks.secrets.client.dto.SecretCreationRequestDto;
import io.lalahtalks.secrets.client.dto.SecretDto;
import io.lalahtalks.secrets.server.domain.secret.*;
import org.springframework.stereotype.Component;

@Component
class SecretDtoMapper {

    SecretDto to(Secret secret) {
        return new SecretDto(
                secret.id().value(),
                secret.name().value(),
                secret.encoded().value(),
                secret.createdAt());
    }

    SecretCreatedDto to(SecretCreated created) {
        return new SecretCreatedDto(
                created.secretId().value(),
                created.createdAt());
    }

    SecretCreationRequest from(SecretCreationRequestDto requestDto) {
        return new SecretCreationRequest(
                new SecretName(requestDto.name()),
                new SecretEncoded(requestDto.encoded()));
    }

}

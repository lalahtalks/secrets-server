package io.lalahtalks.secrets.server.http.api.secret;

import io.lalahtalks.secrets.client.dto.SecretCreatedDto;
import io.lalahtalks.secrets.client.dto.SecretCreationRequestDto;
import io.lalahtalks.secrets.client.dto.SecretDto;
import io.lalahtalks.secrets.server.domain.secret.*;
import org.springframework.stereotype.Component;

@Component
class SecretDtoMapper {

    SecretDto toDto(Secret secret) {
        return SecretDto.builder()
                .id(secret.getId().getValue())
                .name(secret.getName().getValue())
                .encoded(secret.getEncoded().getValue())
                .createdAt(secret.getCreatedAt())
                .build();
    }

    SecretCreatedDto toDto(SecretCreated created) {
        return SecretCreatedDto.builder()
                .secretId(created.getSecretId().getValue())
                .createdAt(created.getCreatedAt())
                .build();
    }

    SecretCreationRequest fromDto(SecretCreationRequestDto requestDto) {
        return SecretCreationRequest.builder()
                .name(new SecretName(requestDto.getName()))
                .encoded(new SecretEncoded(requestDto.getEncoded()))
                .build();
    }

}

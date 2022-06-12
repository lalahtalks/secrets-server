package io.lalahtalks.secrets.server.persistence;

import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.secret.Secret;
import io.lalahtalks.secrets.server.domain.secret.SecretEncoded;
import io.lalahtalks.secrets.server.domain.secret.SecretId;
import io.lalahtalks.secrets.server.domain.secret.SecretName;
import org.springframework.stereotype.Component;

@Component
public class SecretJpaDtoMapper {

    public Secret from(SecretJpaDto dto) {
        return new Secret(
                new SecretId(dto.id),
                new AccountId(dto.accountId),
                new SecretName(dto.name),
                new SecretEncoded(dto.encoded),
                dto.createdAt);
    }

    public SecretJpaDto to(Secret secret) {
        return new SecretJpaDto(
                secret.id().value(),
                secret.accountId().value(),
                secret.name().value(),
                secret.encoded().value(),
                secret.createdAt());
    }

}

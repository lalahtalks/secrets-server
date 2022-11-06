package io.lalahtalks.secrets.server.persistence;

import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.secret.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecretJpaDtoMapper {

    public Secret from(SecretJpaDto dto) {
        var encoded = from(dto.encoded);
        return new Secret(
                new SecretId(dto.id),
                new AccountId(dto.accountId),
                encoded,
                dto.createdAt
        );
    }

    public SecretJpaDto to(Secret secret) {
        var encoded = to(secret.encoded());
        return new SecretJpaDto(
                secret.id().value(),
                secret.accountId().value(),
                encoded,
                secret.createdAt()
        );
    }

    private SecretEncoded from(SecretEncodedJpaDto dto) {
        var url = Optional.ofNullable(dto.url)
                .map(SecretUrl::new);
        var username = Optional.ofNullable(dto.username)
                .map(SecretUsername::new);
        return new SecretEncoded(
                new SecretName(dto.name),
                url,
                username,
                new SecretPassword(dto.password)
        );
    }

    private SecretEncodedJpaDto to(SecretEncoded encoded) {
        var url = encoded.url()
                .map(SecretUrl::value)
                .orElse(null);
        var username = encoded.username()
                .map(SecretUsername::value)
                .orElse(null);
        return new SecretEncodedJpaDto(
                encoded.name().value(),
                url,
                username,
                encoded.password().value()
        );
    }

}

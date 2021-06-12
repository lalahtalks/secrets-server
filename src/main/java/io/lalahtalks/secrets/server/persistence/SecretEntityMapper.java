package io.lalahtalks.secrets.server.persistence;

import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.secret.Secret;
import io.lalahtalks.secrets.server.domain.secret.SecretEncoded;
import io.lalahtalks.secrets.server.domain.secret.SecretId;
import io.lalahtalks.secrets.server.domain.secret.SecretName;
import org.springframework.stereotype.Component;

@Component
public class SecretEntityMapper {

    public Secret fromEntity(SecretEntity entity) {
        return Secret.builder()
                .id(new SecretId(entity.getId()))
                .accountId(new AccountId(entity.getAccountId()))
                .name(new SecretName(entity.getName()))
                .encoded(new SecretEncoded(entity.getEncoded()))
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public SecretEntity toEntity(Secret secret) {
        return SecretEntity.builder()
                .id(secret.getId().getValue())
                .accountId(secret.getAccountId().getValue())
                .name(secret.getName().getValue())
                .encoded(secret.getEncoded().getValue())
                .createdAt(secret.getCreatedAt())
                .build();
    }

}

package io.lalahtalks.secrets.server.domain.secret;

import io.lalahtalks.secrets.server.domain.AccountId;

import java.time.Instant;

public record Secret(
        SecretId id,
        AccountId accountId,
        SecretName name,
        SecretEncoded encoded,
        Instant createdAt) {

}

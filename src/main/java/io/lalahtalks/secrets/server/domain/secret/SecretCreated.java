package io.lalahtalks.secrets.server.domain.secret;

import java.time.Instant;

public record SecretCreated(SecretId secretId, Instant createdAt) {

}

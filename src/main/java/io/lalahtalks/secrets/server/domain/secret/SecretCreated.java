package io.lalahtalks.secrets.server.domain.secret;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class SecretCreated {

    @NonNull SecretId secretId;
    @NonNull Instant createdAt;

}

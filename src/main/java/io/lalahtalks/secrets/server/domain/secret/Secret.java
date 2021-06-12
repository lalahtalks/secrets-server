package io.lalahtalks.secrets.server.domain.secret;

import io.lalahtalks.secrets.server.domain.AccountId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;

@Value
@Builder
public class Secret {

    @NonNull SecretId id;
    @NonNull AccountId accountId;
    @NonNull SecretName name;
    @NonNull SecretEncoded encoded;
    @NonNull Instant createdAt;

}

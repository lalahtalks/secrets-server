package io.lalahtalks.secrets.server.domain.secret;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class SecretCreationRequest {

    @NonNull SecretName name;
    @NonNull SecretEncoded encoded;

}

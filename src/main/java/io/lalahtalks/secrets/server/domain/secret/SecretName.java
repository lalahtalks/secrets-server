package io.lalahtalks.secrets.server.domain.secret;

import lombok.NonNull;
import lombok.Value;

@Value
public class SecretName {

    @NonNull String value;

}

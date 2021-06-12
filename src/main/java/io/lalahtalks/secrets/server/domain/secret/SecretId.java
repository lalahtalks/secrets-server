package io.lalahtalks.secrets.server.domain.secret;

import lombok.NonNull;
import lombok.Value;

@Value
public class SecretId {

    @NonNull String value;

}

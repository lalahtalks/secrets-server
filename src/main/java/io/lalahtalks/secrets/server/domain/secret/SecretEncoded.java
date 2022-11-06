package io.lalahtalks.secrets.server.domain.secret;

import java.util.Optional;

public record SecretEncoded(
        SecretName name,
        Optional<SecretUrl> url,
        Optional<SecretUsername> username,
        SecretPassword password) {

}

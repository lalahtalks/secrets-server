package io.lalahtalks.secrets.server.domain.secret;

public record SecretCreationRequest(SecretName name, SecretEncoded encoded) {

}

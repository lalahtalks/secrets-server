package io.lalahtalks.secrets.server.test;

import io.lalahtalks.paging.dto.PagingDto;
import io.lalahtalks.secrets.client.dto.SecretCreatedDto;
import io.lalahtalks.secrets.client.dto.SecretCreationRequestDto;
import io.lalahtalks.secrets.client.dto.SecretDto;
import io.lalahtalks.secrets.client.dto.SecretPageDto;
import io.lalahtalks.secrets.server.domain.secret.Secret;
import io.lalahtalks.secrets.server.domain.secret.SecretEncoded;
import io.lalahtalks.secrets.server.domain.secret.SecretId;
import io.lalahtalks.secrets.server.domain.secret.SecretName;

import java.util.List;

import static io.lalahtalks.secrets.server.test.DataAccount.ACCOUNT_1_ID;
import static io.lalahtalks.secrets.server.test.DataInstant.NOW;

public class DataSecret {

    public static final String SECRET_1_ID_VALUE = "secret_1";
    public static final SecretId SECRET_1_ID = new SecretId(SECRET_1_ID_VALUE);
    public static final String SECRET_1_NAME_VALUE = "Secret 1";
    public static final SecretName SECRET_1_NAME = new SecretName(SECRET_1_NAME_VALUE);
    public static final String SECRET_1_ENCODED_VALUE = "some_encoded_value";
    public static final SecretEncoded SECRET_1_ENCODED = new SecretEncoded(SECRET_1_ENCODED_VALUE);

    public static final Secret SECRET_1 = new Secret(
            SECRET_1_ID,
            ACCOUNT_1_ID,
            SECRET_1_NAME,
            SECRET_1_ENCODED,
            NOW);

    public static final SecretDto SECRET_1_DTO = new SecretDto(
            SECRET_1_ID_VALUE,
            SECRET_1_NAME_VALUE,
            SECRET_1_ENCODED_VALUE,
            NOW);

    public static final SecretCreationRequestDto SECRET_CREATION_REQUEST_DTO = new SecretCreationRequestDto(
            SECRET_1_NAME_VALUE,
            SECRET_1_ENCODED_VALUE);

    public static final SecretCreatedDto SECRET_CREATED_DTO = new SecretCreatedDto(SECRET_1_ID_VALUE, NOW);

    public static final SecretPageDto SECRET_PAGE_DTO = new SecretPageDto(
            new PagingDto(0, 25, 1L, 1),
            List.of(SECRET_1_DTO));

    private DataSecret() {

    }

}

package io.lalahtalks.secrets.server.test;

import io.lalahtalks.paging.dto.PagingDto;
import io.lalahtalks.secrets.client.dto.*;
import io.lalahtalks.secrets.server.domain.secret.*;

import java.util.List;
import java.util.Optional;

import static io.lalahtalks.secrets.server.test.DataAccount.ACCOUNT_1_ID;
import static io.lalahtalks.secrets.server.test.DataInstant.NOW;

public class DataSecret {

    public static final String SECRET_1_ID_VALUE = "secret_1";
    public static final SecretId SECRET_1_ID = new SecretId(SECRET_1_ID_VALUE);

    public static final String SECRET_2_ID_VALUE = "secret_2";
    public static final SecretId SECRET_2_ID = new SecretId(SECRET_2_ID_VALUE);

    public static final String SECRET_1_NAME_VALUE = "encoded_name";
    public static final SecretName SECRET_1_NAME = new SecretName(SECRET_1_NAME_VALUE);

    public static final String SECRET_1_URL_VALUE = "encoded_url";
    public static final SecretUrl SECRET_1_URL = new SecretUrl(SECRET_1_URL_VALUE);

    public static final String SECRET_1_USERNAME_VALUE = "encoded_username";
    public static final SecretUsername SECRET_1_USERNAME = new SecretUsername(SECRET_1_USERNAME_VALUE);

    public static final String SECRET_1_PASSWORD_VALUE = "encoded_password";
    public static final SecretPassword SECRET_1_PASSWORD = new SecretPassword(SECRET_1_PASSWORD_VALUE);

    public static final SecretEncoded SECRET_1_ENCODED = new SecretEncoded(
            SECRET_1_NAME,
            Optional.of(SECRET_1_URL),
            Optional.of(SECRET_1_USERNAME),
            SECRET_1_PASSWORD
    );

    public static final SecretEncodedDto SECRET_1_ENCODED_DTO = new SecretEncodedDto(
            SECRET_1_NAME_VALUE,
            SECRET_1_URL_VALUE,
            SECRET_1_USERNAME_VALUE,
            SECRET_1_PASSWORD_VALUE
    );

    public static final SecretEncodedDto SECRET_2_ENCODED_DTO = new SecretEncodedDto(
            SECRET_1_NAME_VALUE,
            null,
            null,
            SECRET_1_PASSWORD_VALUE
    );

    public static final Secret SECRET_1 = new Secret(
            SECRET_1_ID,
            ACCOUNT_1_ID,
            SECRET_1_ENCODED,
            NOW
    );

    public static final SecretDto SECRET_1_DTO = new SecretDto(
            SECRET_1_ID_VALUE,
            SECRET_1_ENCODED_DTO,
            NOW
    );

    public static final SecretDto SECRET_2_DTO = new SecretDto(
            SECRET_2_ID_VALUE,
            SECRET_2_ENCODED_DTO,
            NOW
    );

    public static final SecretCreationRequestDto SECRET_CREATION_REQUEST_DTO = new SecretCreationRequestDto(
            SECRET_1_ENCODED_DTO
    );

    public static final SecretCreatedDto SECRET_CREATED_DTO = new SecretCreatedDto(SECRET_1_ID_VALUE, NOW);

    public static final SecretPageDto SECRET_PAGE_DTO = new SecretPageDto(
            new PagingDto(0, 25, 2L, 1),
            List.of(SECRET_1_DTO, SECRET_2_DTO)
    );

    private DataSecret() {

    }

}

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
import lombok.NoArgsConstructor;

import static io.lalahtalks.secrets.server.test.DataAccount.ACCOUNT_1_ID;
import static io.lalahtalks.secrets.server.test.DataInstant.NOW;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DataSecret {

    public static final String SECRET_1_ID_VALUE = "secret_1";
    public static final SecretId SECRET_1_ID = new SecretId(SECRET_1_ID_VALUE);
    public static final String SECRET_1_NAME_VALUE = "Secret 1";
    public static final SecretName SECRET_1_NAME = new SecretName(SECRET_1_NAME_VALUE);
    public static final String SECRET_1_ENCODED_VALUE = "some_encoded_value";
    public static final SecretEncoded SECRET_1_ENCODED = new SecretEncoded(SECRET_1_ENCODED_VALUE);

    public static final Secret SECRET_1 = Secret.builder()
            .id(SECRET_1_ID)
            .accountId(ACCOUNT_1_ID)
            .name(SECRET_1_NAME)
            .encoded(SECRET_1_ENCODED)
            .createdAt(NOW)
            .build();

    public static final SecretDto SECRET_1_DTO = SecretDto.builder()
            .id(SECRET_1_ID_VALUE)
            .name(SECRET_1_NAME_VALUE)
            .encoded(SECRET_1_ENCODED_VALUE)
            .createdAt(NOW)
            .build();

    public static final SecretCreationRequestDto SECRET_CREATION_REQUEST_DTO = SecretCreationRequestDto.builder()
            .name(SECRET_1_NAME_VALUE)
            .encoded(SECRET_1_ENCODED_VALUE)
            .build();

    public static final SecretCreatedDto SECRET_CREATED_DTO = SecretCreatedDto.builder()
            .secretId(SECRET_1_ID_VALUE)
            .createdAt(NOW)
            .build();

    public static final SecretPageDto SECRET_PAGE_DTO = SecretPageDto.builder()
            .paging(PagingDto.builder()
                    .number(0)
                    .size(25)
                    .totalElements(1L)
                    .totalPages(1)
                    .build())
            .element(SECRET_1_DTO)
            .build();

}

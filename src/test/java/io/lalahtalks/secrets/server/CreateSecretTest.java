package io.lalahtalks.secrets.server;

import io.lalahtalks.secrets.client.dto.SecretCreatedDto;
import io.lalahtalks.secrets.server.domain.secret.SecretIdGenerator;
import io.lalahtalks.secrets.server.domain.secret.SecretRepository;
import io.lalahtalks.secrets.server.test.ContextAware;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import static io.lalahtalks.secrets.client.http.contract.SecretsHttpPaths.ACCOUNT_ID;
import static io.lalahtalks.secrets.client.http.contract.SecretsHttpPaths.ACCOUNT_SECRETS_PATH;
import static io.lalahtalks.secrets.server.test.DataAccessToken.ALL_MIGHTY;
import static io.lalahtalks.secrets.server.test.DataAccessToken.NOBODY;
import static io.lalahtalks.secrets.server.test.DataAccount.ACCOUNT_1_ID_VALUE;
import static io.lalahtalks.secrets.server.test.DataSecret.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

class CreateSecretTest extends ContextAware {

    @Autowired
    private SecretIdGenerator secretIdGenerator;

    @Autowired
    private SecretRepository secretRepository;

    @Test
    @Sql("/sql/clean.sql")
    void it_works() {
        doReturn(SECRET_1_ID)
                .when(secretIdGenerator)
                .generate();

        var response = given()
                .auth().preemptive().oauth2(ALL_MIGHTY)
                .with().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(SECRET_CREATION_REQUEST_DTO)
                .pathParam(ACCOUNT_ID, ACCOUNT_1_ID_VALUE)
                .post(ACCOUNT_SECRETS_PATH)
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .extract().as(SecretCreatedDto.class);

        assertThat(response).isEqualTo(SECRET_CREATED_DTO);

        var created = secretRepository.find(SECRET_1_ID);
        assertThat(created).hasValue(SECRET_1);
    }

    @Test
    void forbidden() {
        var response = given()
                .auth().preemptive().oauth2(NOBODY)
                .with().contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(SECRET_CREATION_REQUEST_DTO)
                .pathParam(ACCOUNT_ID, ACCOUNT_1_ID_VALUE)
                .post(ACCOUNT_SECRETS_PATH)
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value())
                .extract().as(Problem.class);

        assertThat(response.getStatus()).isEqualTo(Status.FORBIDDEN);
    }

}

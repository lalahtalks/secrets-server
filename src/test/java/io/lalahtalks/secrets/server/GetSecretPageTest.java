package io.lalahtalks.secrets.server;

import io.lalahtalks.secrets.client.dto.SecretPageDto;
import io.lalahtalks.secrets.server.domain.IdGenerator;
import io.lalahtalks.secrets.server.domain.secret.SecretRepository;
import io.lalahtalks.secrets.server.test.ContextAware;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static io.lalahtalks.secrets.client.http.contract.SecretsHttpPaths.ACCOUNT_ID;
import static io.lalahtalks.secrets.client.http.contract.SecretsHttpPaths.ACCOUNT_SECRETS_PATH;
import static io.lalahtalks.secrets.server.test.DataAccessToken.ALL_MIGHTY;
import static io.lalahtalks.secrets.server.test.DataAccount.ACCOUNT_1_ID_VALUE;
import static io.lalahtalks.secrets.server.test.DataSecret.SECRET_PAGE_DTO;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetSecretPageTest extends ContextAware {

    @Autowired
    private IdGenerator idGenerator;

    @Autowired
    private SecretRepository secretRepository;

    @Test
    @Sql({"/sql/clean.sql", "/sql/insert.sql"})
    void it_works() {
        var response = given()
                .auth().preemptive().oauth2(ALL_MIGHTY)
                .with().contentType(MediaType.APPLICATION_JSON_VALUE)
                .pathParam(ACCOUNT_ID, ACCOUNT_1_ID_VALUE)
                .queryParam("page", 0)
                .queryParam("size", 25)
                .get(ACCOUNT_SECRETS_PATH)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().as(SecretPageDto.class);

        assertThat(response).isEqualTo(SECRET_PAGE_DTO);
    }

}

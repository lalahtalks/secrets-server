package io.lalahtalks.secrets.server.persistence;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "secret")
public class SecretJpaDto {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "accountId")
    String accountId;

    @Embedded
    SecretEncodedJpaDto encoded;

    @Column(name = "created_at")
    Instant createdAt;

    public SecretJpaDto() {

    }

    public SecretJpaDto(String id, String accountId, SecretEncodedJpaDto encoded, Instant createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.encoded = encoded;
        this.createdAt = createdAt;
    }

}

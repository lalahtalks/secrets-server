package io.lalahtalks.secrets.server.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "secret")
public class SecretJpaDto {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "accountId")
    String accountId;

    @Column(name = "name")
    String name;

    @Column(name = "encoded")
    String encoded;

    @Column(name = "created_at")
    Instant createdAt;

    public SecretJpaDto() {

    }

    public SecretJpaDto(String id, String accountId, String name, String encoded, Instant createdAt) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.encoded = encoded;
        this.createdAt = createdAt;
    }

}

package io.lalahtalks.secrets.server.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "secret")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecretEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "accountId")
    private String accountId;

    @Column(name = "name")
    private String name;

    @Column(name = "encoded")
    private String encoded;

    @Column(name = "created_at")
    private Instant createdAt;

}

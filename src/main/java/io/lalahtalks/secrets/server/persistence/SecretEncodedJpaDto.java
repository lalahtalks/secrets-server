package io.lalahtalks.secrets.server.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SecretEncodedJpaDto {

    @Column(name = "name")
    String name;

    @Column(name = "url")
    String url;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    public SecretEncodedJpaDto() {

    }

    public SecretEncodedJpaDto(String name, String url, String username, String password) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
    }

}

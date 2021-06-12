package io.lalahtalks.secrets.server.domain.secret;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.PageRequest;
import io.lalahtalks.secrets.server.domain.AccountId;

import java.util.Optional;

public interface SecretRepository {

    Page<Secret> find(AccountId accountId, PageRequest request);

    Optional<Secret> find(SecretId secretId);

    void save(Secret secret);

}

package io.lalahtalks.secrets.server.domain.secret;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.PageRequest;
import io.lalahtalks.secrets.server.domain.AccountId;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;

@Component
public class SecretService {

    private final Clock clock;
    private final SecretIdGenerator secretIdGenerator;
    private final SecretRepository secretRepository;

    public SecretService(Clock clock, SecretIdGenerator secretIdGenerator, SecretRepository secretRepository) {
        this.clock = clock;
        this.secretIdGenerator = secretIdGenerator;
        this.secretRepository = secretRepository;
    }

    @Transactional(readOnly = true)
    public Page<Secret> getPage(AccountId accountId, PageRequest request) {
        return secretRepository.find(accountId, request);
    }

    @Transactional
    public SecretCreated create(AccountId accountId, SecretCreationRequest request) {
        var now = clock.instant();
        var secretId = secretIdGenerator.generate();
        var secret = new Secret(
                secretId,
                accountId,
                request.encoded(),
                now);
        secretRepository.save(secret);
        return new SecretCreated(secretId, now);
    }

}

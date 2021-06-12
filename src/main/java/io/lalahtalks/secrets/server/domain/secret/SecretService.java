package io.lalahtalks.secrets.server.domain.secret;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.PageRequest;
import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
@RequiredArgsConstructor
public class SecretService {

    private final Clock clock;
    private final IdGenerator idGenerator;
    private final SecretRepository secretRepository;

    public Page<Secret> getPage(AccountId accountId, PageRequest request) {
        return secretRepository.find(accountId, request);
    }

    public SecretCreated create(AccountId accountId, SecretCreationRequest request) {
        var now = clock.instant();
        var secretId = new SecretId(idGenerator.generate());
        var secret = Secret.builder()
                .id(secretId)
                .accountId(accountId)
                .name(request.getName())
                .encoded(request.getEncoded())
                .createdAt(now)
                .build();
        secretRepository.save(secret);
        return SecretCreated.builder()
                .secretId(secretId)
                .createdAt(now)
                .build();
    }

}

package io.lalahtalks.secrets.server.persistence;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.PageRequest;
import io.lalahtalks.paging.domain.Paging;
import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.secret.Secret;
import io.lalahtalks.secrets.server.domain.secret.SecretId;
import io.lalahtalks.secrets.server.domain.secret.SecretRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JpaSecretRepository implements SecretRepository {

    private final SecretEntityMapper secretEntityMapper;
    private final SecretEntityRepository secretEntityRepository;

    @Override
    public Page<Secret> find(AccountId accountId, PageRequest request) {
        var offset = request.getPageNumber() * request.getPageSize();
        var totalElements = secretEntityRepository.countByAccountId(accountId.getValue());
        var totalPages = totalElements != 0
                ? ((int) totalElements / request.getPageSize()) + 1
                : 0;
        var entities = secretEntityRepository.findAllByAccountIdAndPageRequest(
                accountId.getValue(),
                request.getPageSize(),
                offset);
        var elements = entities.stream()
                .map(secretEntityMapper::fromEntity)
                .collect(Collectors.toList());
        var paging = Paging.builder()
                .number(request.getPageNumber())
                .size(request.getPageSize())
                .totalElements(totalElements)
                .totalPages(totalPages)
                .build();
        return Page.<Secret>builder()
                .paging(paging)
                .elements(elements)
                .build();
    }

    @Override
    public Optional<Secret> find(SecretId secretId) {
        return secretEntityRepository.findById(secretId.getValue())
                .map(secretEntityMapper::fromEntity);
    }

    @Override
    public void save(Secret secret) {
        var entity = secretEntityMapper.toEntity(secret);
        secretEntityRepository.save(entity);
    }

}

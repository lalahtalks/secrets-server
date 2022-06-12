package io.lalahtalks.secrets.server.persistence;

import io.lalahtalks.paging.domain.Page;
import io.lalahtalks.paging.domain.PageRequest;
import io.lalahtalks.paging.domain.Paging;
import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.secret.Secret;
import io.lalahtalks.secrets.server.domain.secret.SecretId;
import io.lalahtalks.secrets.server.domain.secret.SecretRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaSecretRepository implements SecretRepository {

    private final SecretJpaDtoMapper secretJpaDtoMapper;
    private final SecretDao secretDao;

    public JpaSecretRepository(SecretJpaDtoMapper secretJpaDtoMapper, SecretDao secretDao) {
        this.secretJpaDtoMapper = secretJpaDtoMapper;
        this.secretDao = secretDao;
    }

    @Override
    public Page<Secret> find(AccountId accountId, PageRequest request) {
        var offset = request.pageNumber() * request.pageSize();
        var totalElements = secretDao.countByAccountId(accountId.value());
        var totalPages = totalElements != 0
                ? ((int) totalElements / request.pageSize()) + 1
                : 0;
        var entities = secretDao.findAllByAccountIdAndPageRequest(
                accountId.value(),
                request.pageSize(),
                offset);
        var elements = entities.stream()
                .map(secretJpaDtoMapper::from)
                .toList();
        var paging = new Paging(
                request.pageNumber(),
                request.pageSize(),
                totalElements,
                totalPages);
        return new Page<>(paging, elements);
    }

    @Override
    public Optional<Secret> find(SecretId secretId) {
        return secretDao.findById(secretId.value())
                .map(secretJpaDtoMapper::from);
    }

    @Override
    public void save(Secret secret) {
        var dto = secretJpaDtoMapper.to(secret);
        secretDao.save(dto);
    }

}

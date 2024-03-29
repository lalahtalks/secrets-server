package io.lalahtalks.secrets.server.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecretDao extends JpaRepository<SecretJpaDto, String> {

    @Query(nativeQuery = true,
            value = "select * from secret"
                    + " where account_id = :account_id"
                    + " limit :limit"
                    + " offset :offset")
    List<SecretJpaDto> findAllByAccountIdAndPageRequest(
            @Param("account_id") String accountId,
            @Param("limit") Integer limit,
            @Param("offset") Integer offset);

    long countByAccountId(String accountId);

}

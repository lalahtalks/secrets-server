package io.lalahtalks.secrets.server.http.api.secret;

import io.lalahtalks.paging.domain.PageRequest;
import io.lalahtalks.paging.dto.PageDto;
import io.lalahtalks.paging.dto.PageDtoMapper;
import io.lalahtalks.secrets.client.dto.SecretCreatedDto;
import io.lalahtalks.secrets.client.dto.SecretCreationRequestDto;
import io.lalahtalks.secrets.client.dto.SecretDto;
import io.lalahtalks.secrets.server.domain.AccountId;
import io.lalahtalks.secrets.server.domain.secret.SecretService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static io.lalahtalks.secrets.client.http.contract.SecretsHttpPaths.ACCOUNT_ID;
import static io.lalahtalks.secrets.client.http.contract.SecretsHttpPaths.ACCOUNT_SECRETS_PATH;

@RestController
@RequestMapping(ACCOUNT_SECRETS_PATH)
@RequiredArgsConstructor
public class AccountSecretsController {

    private final PageDtoMapper pageDtoMapper;
    private final SecretDtoMapper secretDtoMapper;
    private final SecretService secretService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    PageDto<SecretDto> getPage(
            @PathVariable(ACCOUNT_ID) String accountIdValue,
            @RequestParam("page") int pageNumber,
            @RequestParam("size") int pageSize) {
        var accountId = new AccountId(accountIdValue);
        var request = PageRequest.of(pageNumber, pageSize);
        var page = secretService.getPage(accountId, request);
        return pageDtoMapper.toDto(page, secretDtoMapper::toDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    SecretCreatedDto create(
            @PathVariable(ACCOUNT_ID) String accountIdValue,
            @RequestBody SecretCreationRequestDto requestDto) {
        var accountId = new AccountId(accountIdValue);
        var request = secretDtoMapper.fromDto(requestDto);
        var created = secretService.create(accountId, request);
        return secretDtoMapper.toDto(created);
    }

}

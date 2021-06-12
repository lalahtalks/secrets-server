package io.lalahtalks.secrets.server.test;

import io.lalahtalks.secrets.server.domain.AccountId;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DataAccount {

    public static final String ACCOUNT_1_ID_VALUE = "account_1";
    public static final AccountId ACCOUNT_1_ID = new AccountId(ACCOUNT_1_ID_VALUE);

}

package net.spring.Banking.mapper;

import net.spring.Banking.dto.AccountDto;
import net.spring.Banking.model.Account;

// This class provides static methods for mapping between Account and AccountDto objects
public class AccountMapper {

    // Method to map from AccountDto to Account
    public static Account mapToAccount(AccountDto accountDto) {
        // Create a new Account object using data from AccountDto
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountUsername(),
                accountDto.getBalance());
        return account;
    }

    // Method to map from Account to AccountDto
    public static AccountDto mapToAccountDto(Account account) {
        // Create a new AccountDto object using data from Account
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountUsername(),
                account.getBalance()
        );
        return accountDto;
    }
}


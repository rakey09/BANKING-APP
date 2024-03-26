package net.spring.Banking.service;

import net.spring.Banking.dto.AccountDto;

import java.util.List;

// Interface defining the methods for account management
public interface AccountService {

    // Method to create a new account
    AccountDto createAccount(AccountDto accountDto);

    // Method to retrieve an account by its unique identifier
    AccountDto getAccountById(long id);

    // Method to deposit funds into an account
    AccountDto deposit(long id, double amount);

    // Method to withdraw funds from an account
    AccountDto withdraw(long id, double amount);

    // Method to retrieve all accounts
    List<AccountDto> getAllAccounts();

    // Method to delete an account by its unique identifier
    void deleteAccount(long id);
}


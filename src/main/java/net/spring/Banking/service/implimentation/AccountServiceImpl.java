package net.spring.Banking.service.implimentation;

import net.spring.Banking.dto.AccountDto;
import net.spring.Banking.mapper.AccountMapper;
import net.spring.Banking.model.Account;
import net.spring.Banking.repository.AccountRepository;
import net.spring.Banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Annotation to mark this class as a Spring service component
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    // Constructor injection of AccountRepository
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // Mapping AccountDto to Account entity
        Account account = AccountMapper.mapToAccount(accountDto);
        // Saving the account to the repository
        Account savedAccount = accountRepository.save(account);
        // Mapping the saved Account entity back to AccountDto
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(long id) {
        // Retrieving account by id from repository
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account doesn't Exists"));
        // Mapping Account entity to AccountDto
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(long id, double amount) {
        // Retrieving account by id from repository
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account doesn't Exists"));
        // Adding the deposit amount to the account balance
        double total = account.getBalance() + amount;
        account.setBalance(total);
        // Saving the updated account to the repository
        Account savedAmount = accountRepository.save(account);
        // Mapping the saved Account entity back to AccountDto
        return AccountMapper.mapToAccountDto(savedAmount);
    }

    @Override
    public AccountDto withdraw(long id, double amount) {
        // Retrieving account by id from repository
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account doesn't Exists"));
        // Checking if account balance is sufficient for withdrawal
        if (account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }
        // Subtracting the withdrawal amount from the account balance
        double total = account.getBalance() - amount;
        account.setBalance(total);
        // Saving the updated account to the repository
        Account savedAmount = accountRepository.save(account);
        // Mapping the saved Account entity back to AccountDto
        return AccountMapper.mapToAccountDto(savedAmount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        // Retrieving all accounts from repository
        List<Account> accounts = accountRepository.findAll();
        // Mapping each Account entity to AccountDto and collecting them into a list
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(long id) {
        // Checking if account exists
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account doesn't Exists"));
        // Deleting account from repository
        accountRepository.deleteById(id);
    }
}


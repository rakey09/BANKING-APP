package net.spring.Banking.repository;

import net.spring.Banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository to inherit basic CRUD operations for the Account entity
public interface AccountRepository extends JpaRepository<Account, Long> {
}


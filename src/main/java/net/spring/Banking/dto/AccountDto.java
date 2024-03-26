package net.spring.Banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class AccountDto {

    private long id; // Unique identifier for the account
    private String accountUsername; // Username associated with the account
    private double balance; // Current balance of the account
}


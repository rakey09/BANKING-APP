package net.spring.Banking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations to automatically generate constructors, getters, setters, and no-args constructor
@NoArgsConstructor // Creates a no-args constructor
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@AllArgsConstructor // Creates a constructor with all arguments
@Table(name = "Accounts") // Specifies the name of the table in the database
@Entity // Marks this class as a JPA entity, representing a table in the database
public class Account {

    @Id // Indicates that this field is the primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private long id; // Unique identifier for the account

    private String accountUsername; // Username associated with the account
    private double balance; // Current balance of the account
}


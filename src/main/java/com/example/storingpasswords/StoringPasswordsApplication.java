package com.example.storingpasswords;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StoringPasswordsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StoringPasswordsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String hashedAndSalted = new BCryptPasswordEncoder().encode("12345");
        System.out.println("Hashed and salted: " + hashedAndSalted);

        String passwordLogin = "12346";
        boolean isPasswordMatched = new BCryptPasswordEncoder().matches(passwordLogin, hashedAndSalted);

        System.out.println("Password matched: " + isPasswordMatched);
    }

}

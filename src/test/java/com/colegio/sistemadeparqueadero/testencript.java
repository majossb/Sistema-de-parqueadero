package com.colegio.sistemadeparqueadero;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
public class testencript {

    @Autowired
    private PasswordEncoder encoder;

    @Test
    void imprimeHash() {
        String plain = "";
        String hash  = encoder.encode(plain);
        System.out.println("BCrypt de '" + plain + "': " + hash);
    }
}

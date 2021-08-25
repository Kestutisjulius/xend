package com.javavilnius10.config;

import com.github.javafaker.Faker;
import com.javavilnius10.model.Authority;
import com.javavilnius10.model.Product;
import com.javavilnius10.model.SalesLine;
import com.javavilnius10.model.User;
import com.javavilnius10.reposirory.ProductRepository;
import com.javavilnius10.reposirory.SalesLineRepository;
import com.javavilnius10.reposirory.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Configuration
public class PredefinedDataFillerUSER {

    Faker faker = new Faker();

//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository, ProductRepository productRepository, SalesLineRepository salesLineRepository) {
//        return args -> {
//            productRepository.save(new Product(faker.expression("thing"), faker.gameOfThrones().city(), faker.number().randomDouble(3, 1,99), faker.number().randomDouble(3,1, 99), faker.number().randomDouble(3,1, 99), faker.university().name()));
//            productRepository.save(new Product(faker.expression("thing"), faker.gameOfThrones().city(), faker.number().randomDouble(3, 1,99), faker.number().randomDouble(3,1, 99), faker.number().randomDouble(3,1, 99), faker.university().name()));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "user", faker.code().ean8(), true, true));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "admin", faker.code().ean8(), true, true));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "user", faker.code().ean8(), true, true));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "admin", faker.code().ean8(), true, true));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "user", faker.code().ean8(), true, true));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "user", faker.code().ean8(), true, true));
//            userRepository.save(new User(faker.company().name(), null, faker.company().bs(), faker.code().asin(), faker.phoneNumber().phoneNumber(), faker.address().streetAddressNumber(), faker.internet().emailAddress(), faker.finance().creditCard(), "user", faker.code().ean8(), true, true));
//            salesLineRepository.save(new SalesLine(faker.file().fileName(), faker.number().randomDouble(2,1,99)));
//
//        };
//    }
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, ProductRepository productRepository, SalesLineRepository salesLineRepository, PasswordEncoder passwordEncoder) {
        return args -> {
//            String encodedPassword = passwordEncoder.encode("admin");
//            User user = new User();
//            user.setPassword(encodedPassword);
//            user.setUsername("admiral");
//            user.setEnabled(Boolean.TRUE);
//            Authority authority = new Authority();
//            authority.setUser(user);
//            authority.setAuthority("ADMIN");
//            user.setAuthority(authority);
//            userRepository.save(user);
        };
//    return null;
    }

}


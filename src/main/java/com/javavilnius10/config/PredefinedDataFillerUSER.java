package com.javavilnius10.config;

import com.javavilnius10.model.User;
import com.javavilnius10.reposirory.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PredefinedDataFillerUSER {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("UAB company", "LT112455422554", "1235444", "+37055448877", "Gedimino str. 11", "company@gmail.com", "SWED LT212254478", "user1", "user1", true, true,null));
            userRepository.save(new User("UAB OLIALIA", "LT2558741", "2355448", "+371895456", "Laisves str. 11", "olia@gmail.com", "SEB LT45658787", "user2", "user2", false, false, null));
            userRepository.save(new User("UAB LTCEO", "LT162455522594", "239449", "+370558741", "Zalgyrio str. 15", "ltceo@gmail.com", "LUMINOR L485354896", "user3", "user3", false, false, null));
        };
    }
}

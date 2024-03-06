package com.tutorial.Shoppy.appuser;
//
//import lombok.AllArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.List;
//
//@Configuration
//@AllArgsConstructor
//public class AppUserConfig {
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository){
//        return args -> {
//            String encodedPassword = bCryptPasswordEncoder.encode("123");
//            AppUser user = new AppUser("John", "Doe", "123", encodedPassword, AppUserRole.USER);
//
//
//            repository.saveAll(List.of(user));
//        };
//    }
//}

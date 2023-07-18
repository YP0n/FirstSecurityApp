package ua.ypon.springcourse.FirstSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.ypon.springcourse.FirstSecurityApp.services.PersonDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Bean
    public org.springframework.security.web.DefaultSecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //конфігуруємо сам spring security
        //конфігуруємо авторизацію
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/login", "/auth/registration", "/error").permitAll()
                .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin.loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/hello", true)
                .failureUrl("/auth/login?error"))
                .logout(log -> log.logoutUrl("/logout"))
                .logout(logSuc -> logSuc.logoutSuccessUrl("/auth/login"));

        return httpSecurity.build();

    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests(authz -> authz
//                .requestMatchers("/auth/login", "/error").permitAll()
//                .anyRequest().authenticated());
//    }


    //Налаштування футентифікації
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(personDetailsService);
        }

        @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        }
    }


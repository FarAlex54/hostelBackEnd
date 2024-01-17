package com.example.hostelbackend.config;

import com.example.hostelbackend.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
    private final PersonDetailsService personDetailsService;
    @Bean
    public PasswordEncoder getPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(personDetailsService)
                .passwordEncoder(getPasswordEncode());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.csrf((csrf) -> csrf.disable()) //отключение защиты от межсайтовой подделки запросов ВАЖНО!!!!! - для продакшена строка должна закоментирована
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin").hasRole("ADMIN") //админка доступна только роли ROLE_ADMIN
                        .requestMatchers("/authentication","/error","/registration","/static/**","/css/**","/Teaching/**","/Packages/**").permitAll() //доступные страницы всем смертным
                        .anyRequest().hasAnyRole("USER","ADMIN")) //остальные страницы которые появятся в проекте будут доступны этим ролям
                //но нужно будет переделать и поставить permitALL()
                //.anyRequest().authenticated()) //для всех остальных страниц необходимо вызывать метод authenticated() который открывает форму аутентификации
                .formLogin(form -> form
                        .loginPage("/authentication") //указан какой url запрос будет отправляться при заходе на защищенные страницы
                        .loginProcessingUrl("/process_login")// указываем на какой адрес будут отправляться данные с формы.
                        .defaultSuccessUrl("/index",true)//указываем на какой url необходимо направить пользователя
                        //после успешной аутентификации. Вторым аргументом идет true чтобы
                        //перенаправиление шло в любом случае после успешной аутентификации
                        .failureUrl("/authentication?error"))//указываем перенаправление пользователя при провальной аутентификации
                //В запрос будет передан обьект error, который будет проверятся на форме
                //и при наличии данного обекта в запросе выводится сообщ "Неверный логин/пароль"
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index"));
        return http.build();
    }
    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

}
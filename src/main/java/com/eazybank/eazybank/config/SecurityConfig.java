package com.eazybank.eazybank.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests().anyRequest().denyAll().and().httpBasic().and().formLogin(); //deny all the request
////        http.authorizeHttpRequests().anyRequest().permitAll().and().httpBasic().and().formLogin();// permit all the request
////        http.authorizeRequests()
////                        .requestMatchers("/accounts","/cards","/balance","/loans").authenticated()
////                        .requestMatchers("/notices","/contacts").permitAll()
////                        .and().
////                httpBasic().
////                and().
////                formLogin();
//        return http.build();
//    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests()
                .requestMatchers("/accounts","/loans","/cards","balance").authenticated()
                .requestMatchers("/contacts","/notices").permitAll()
                .and().httpBasic().and().formLogin();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        /**
         * approach 1 where i use withdefualtPasswordEncoder() method while creating the user details
         */

//        UserDetails admin= User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        UserDetails user= User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .authorities("read")
//                .build();
        /**
         * approach 1 where i use NoOpPasswordEncoderBean method while creating the user details
         */
        UserDetails admin= User.withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();
        UserDetails user= User.withUsername("user")
                .password("12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
        }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

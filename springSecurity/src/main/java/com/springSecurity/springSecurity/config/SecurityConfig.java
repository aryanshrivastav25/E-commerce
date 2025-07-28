package com.springSecurity.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{

    @Bean
    public BCryptPasswordEncoder getEncoder()
    {
        return new BCryptPasswordEncoder(12);
    }


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired 
    private JwtFilter jwtFilter;


    @Bean
    public AuthenticationProvider authProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); // to connect to database to store users
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }


    @Bean // Whenever an object of SecurityFilterChain is required by spring, it will get it from here, so it is a spring managed bean
    // overwrites the default spring security's SecurityFilterChain, so it will not sshow the spring securty's default login form, if not handled properly
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        // http.csrf(customizer -> customizer.disable()); // disable the csrf token
        // http.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // Enable form requests for login
        // http.httpBasic(Customizer.withDefaults()); // Enables to security show form on browser
        // http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // makes it stateless so it will show different session id each time
        // return http.build(); // return a SecurityFilterChain object

        // By doing this, we do not need to send the CSRF Tokens, instead we have a different session id each time we reload

        // Customizer<CsrfConfigurer<HttpSecurity>> customCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {

        //     @Override
        //     public void customize(CsrfConfigurer<HttpSecurity> t) {
        //         t.disable(); // Disable csrf token
        //     }
            
        // };
        // http.csrf(customCsrf); // Disable csrf token


        // Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> customAuth = new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {

        //     @Override
        //     public void customize(
        //             AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry t) {
        //                 // Means authenticate any request after login
        //         t.anyRequest().authenticated();
        //     }
            
        // };
        // http.authorizeHttpRequests(customAuth); 


        
        // Customizer<HttpBasicConfigurer<HttpSecurity>> customBasic = new Customizer<HttpBasicConfigurer<HttpSecurity>>() {

        //     @Override
        //     public void customize(HttpBasicConfigurer<HttpSecurity> t) {
        //         Customizer.withDefaults(); // Default spring configs which does not alter the user input
        //     }
            
        // };
        // http.httpBasic(customBasic);

        // Customizer<SessionManagementConfigurer<HttpSecurity>> customSession = new Customizer<SessionManagementConfigurer<HttpSecurity>>() {

        //     @Override
        //     public void customize(SessionManagementConfigurer<HttpSecurity> t) {
        //         t.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //     }
            
        // };
        // http.sessionManagement(customSession);

        http
            .cors(Customizer.withDefaults())
            .csrf(customizer -> customizer.disable())
            .authorizeHttpRequests(request -> request
            .requestMatchers("/register", "/login").permitAll() // allows register url to be accessed without login i.e. a user can register without able to log in
            .anyRequest().authenticated())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
    {
        return configuration.getAuthenticationManager();
    }


//     @Bean
//     // Will overwrite the username and password in application.properties
//     public UserDetailsService userDetailsService() // UserDetailsService object will contain the user info which is used by spring to log in the user
//     {
//         UserDetails user1 = User
//                             .withDefaultPasswordEncoder()
//                             .username("Aryan")
//                             .password("12345")
//                             .roles("USER")   
//                             .build(); // A single user for getting user details

//         UserDetails user2 = User
//                             .withDefaultPasswordEncoder()
//                             .username("Ayush")
//                             .password("123")
//                             .roles("ADMIN")   
//                             .build(); 
//         return new InMemoryUserDetailsManager(user1, user2);
//     }
}

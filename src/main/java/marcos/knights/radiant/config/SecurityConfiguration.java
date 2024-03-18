package marcos.knights.radiant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import marcos.knights.radiant.config.jwt.JwtAuthenticationFilter;
import marcos.knights.radiant.config.jwt.JwtAuthorizationFilter;
import marcos.knights.radiant.config.jwt.JwtTokenUtils;
import marcos.knights.radiant.services.user.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtTokenUtils tokenUtils;
    private final UserService service;

    @Autowired
    public SecurityConfiguration(JwtTokenUtils tokenUtils, UserService service) {
        this.tokenUtils = tokenUtils;
        this.service = service;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        AuthenticationManager authManager = authManager(http);
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                                .requestMatchers("/error/**").permitAll()
                                // login / register
                                .requestMatchers(
                                    // KnightRadiant
                                        // POST
                                        mvc.pattern("/knightsRadiant/knightRadiant/create"),
                                    // Users
                                        // POST
                                        mvc.pattern("/knightsRadiant/users/create"),
                                        mvc.pattern("/knightsRadiant/users/register"),
                                        mvc.pattern("/knightsRadiant/users/login")
                                        ).permitAll()

                                .requestMatchers(
                                    // Missions
                                        // POST
                                        "/knightsRadiant/missions/create"

                                ).hasAnyRole("THIRD_IDEAL", "FOURTH_IDEAL", "FIFTH_IDEAL")

                                .requestMatchers(
                                    // Users
                                        // GET
                                        "/knightsRadiant/users",
                                        "/knightsRadiant/users/id/{id}",
                                        "/knightsRadiant/users/email/{email}"

                                ).hasAnyRole("NO_IDEAL", "FIRST_IDEAL", "SECOND_IDEAL", "THIRD_IDEAL", "FOURTH_IDEAL", "FIFTH_IDEAL")
                                // Cualquier otra request con lo que sea (en esta caso autenticación)
                                .anyRequest().authenticated()
                        //.anyRequest().permitAll()
                )
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilter(jwtAuthorizationFilter(authManager))
                .sessionManagement(customizer -> customizer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(AuthenticationManager manager) {
        return new JwtAuthorizationFilter(tokenUtils, service, manager);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(service);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(service);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
}
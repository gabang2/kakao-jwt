package jwt.kakao.jwt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jwt.kakao.jwt.filter.JwtExceptionFilter;
import jwt.kakao.jwt.filter.JwtFilter;
import jwt.kakao.oauth.service.OauthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig {

    OauthService oAuthService;

    @Value("${jwt.secret}")
    private String secretKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt 사용하는 경우 사용
                .and()
                .authorizeRequests(authorize -> authorize.antMatchers("/login").permitAll())
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .addFilterBefore(new JwtFilter(secretKey), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtExceptionFilter(objectMapper), JwtFilter.class)
                .build()
                ;
    }
}
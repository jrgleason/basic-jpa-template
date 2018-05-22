package org.gleason.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.ws.rs.HttpMethod;
import java.io.UnsupportedEncodingException;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {
    private static final String[] NO_AUTH = {
            "/",
            "/bundle.js",
            "/login",
            "/callback",
            "/actuator/health"
    };
    private static final String[] AUTH = {
            "/**"
    };
//    @Value(value = "${com.auth0.domain}")
//    private String domain;
//    @Value(value = "${com.auth0.clientId}")
//    private String clientId;
//    @Value(value = "${com.auth0.clientSecret}")
//    private String clientSecret;
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
                .antMatchers(NO_AUTH).permitAll()
                .antMatchers(AUTH).authenticated();
    }
}

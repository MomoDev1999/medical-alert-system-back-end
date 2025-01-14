package com.medical.alert.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.decoder(jwtDecoder())) // Configuración del decodificador JWT
                );
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        // URL de la autoridad que emite los tokens (e.g., Azure AD B2C)
        String issuerUri = "https://<TENANT_NAME>.b2clogin.com/<TENANT_ID>/v2.0";

        // Crea el decodificador con validación de issuer
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(issuerUri + "/discovery/v2.0/keys").build();
        jwtDecoder.setJwtValidator(JwtValidators.createDefaultWithIssuer(issuerUri));
        return jwtDecoder;
    }
}

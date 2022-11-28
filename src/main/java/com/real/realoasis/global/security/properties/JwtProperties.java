package com.real.realoasis.global.security.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt.secret")
public class JwtProperties {
    private String key;
}

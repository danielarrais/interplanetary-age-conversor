package dev.danielarrais.config;

import dev.danielarrais.interplanetaryageconversor.domain.AgeConversor;
import dev.danielarrais.interplanetaryageconversor.service.AgeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgeConverterBean {
    @Bean
    public AgeConverter ageConverter(AgeConversor ageConversor) {
        return new AgeConverter(ageConversor);
    }
    @Bean
    public AgeConversor ageConversor() {
        return new AgeConversor();
    }
}

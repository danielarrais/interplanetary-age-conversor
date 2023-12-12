package dev.danielarrais.api;

import dev.danielarrais.api.dto.AgeConverterRequest;
import dev.danielarrais.interplanetaryageconversor.service.AgeConverter;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/age-conversor")
public class AgeConversorController {
    private final AgeConverter ageConverter;

    public AgeConversorController(AgeConverter ageConverter) {
        this.ageConverter = ageConverter;
    }

    @PostMapping
    public Double convertAge(@RequestBody @Valid AgeConverterRequest request) {
        return this.ageConverter.convert(request.getSeconds(), request.getPlanet());
    }
}

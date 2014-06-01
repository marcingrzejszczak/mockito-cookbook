package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpring;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ReusedMockTaxConfiguration {

    @Bean
    public TaxService taxService() {
        return Mockito.mock(TaxService.class);
    }

}

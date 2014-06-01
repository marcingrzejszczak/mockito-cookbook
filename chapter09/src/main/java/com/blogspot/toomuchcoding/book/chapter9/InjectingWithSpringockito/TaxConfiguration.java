package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringockito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TaxConfiguration {

    @Bean
    public TaxService taxService() {
        return new TaxService();
    }

    @Bean
    public TaxTransferer taxTransferer(TaxService taxService) {
        return new TaxTransferer(taxService);
    }

}

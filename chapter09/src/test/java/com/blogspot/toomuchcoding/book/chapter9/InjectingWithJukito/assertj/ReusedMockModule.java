package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito.assertj;

import org.mockito.Mockito;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.google.inject.AbstractModule;

public class ReusedMockModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TaxService.class).toInstance(Mockito.mock(TaxService.class));
    }

}

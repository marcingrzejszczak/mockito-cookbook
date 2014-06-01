package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.assertj;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import org.mockito.Mockito;

import com.google.inject.AbstractModule;

public class ReusedMockModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TaxService.class).toInstance(Mockito.mock(TaxService.class));
    }

}

package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.google.inject.AbstractModule;
import org.mockito.Mockito;

public class ReusedMockModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TaxService.class).toInstance(Mockito.mock(TaxService.class));
    }

}

package com.blogspot.toomuchcoding.book.chapter9.InjectingWithJukito;

import com.google.inject.AbstractModule;

public class TaxModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TaxService.class).to(TaxWebService.class);
    }

}

package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice;

import com.google.inject.AbstractModule;

class TaxModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TaxService.class).to(TaxWebService.class);
    }

}

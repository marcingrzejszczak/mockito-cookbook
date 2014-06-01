package com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.hamcrest;

import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxService;
import com.blogspot.toomuchcoding.book.chapter9.InjectingWithGuice.TaxTransferer;
import com.blogspot.toomuchcoding.book.chapter9.exception.CustomException;
import com.blogspot.toomuchcoding.person.Person;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.runners.MockitoJUnitRunner;

import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionBdd.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;

/**
 * Added prefixes to test method names to ensure method execution order
 */
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaxTransfererReusedMockTest {

    TaxTransferer taxTransferer;

    TaxService taxService;

    /**
     * You can also do it like this:
     * Guice.createInjector(Modules.override(new ProductionModule()).with(new TestModule()));
     *
     * But as the javadoc for Modules.overrides(..) recommends, you should design your modules
     * in such a way that you don't need to override bindings. Solution: move classes to be mocked
     * to separate modules
     */
    @Before
    public void setup() {
        Injector injector = Guice.createInjector(new MockModule());
        taxTransferer = injector.getInstance(TaxTransferer.class);
        taxService = injector.getInstance(TaxService.class);
    }

	@Test
	public void _1_should_fail_to_transfer_tax_for_person() {
		// given
		Person person = new Person();
		willThrow(CustomException.class).given(taxService).transferTaxFor(any(Person.class));

		// when
		when(taxTransferer).transferTaxFor(person);

		// then
		assertThat(caughtException(), instanceOf(CustomException.class));
		verify(taxService).transferTaxFor(person);
	}

	@Test
	public void _2_should_transfer_tax_for_person_since_injector_is_recreated_with_each_test() {
		// given
		Person person = new Person();

		// when
		boolean transferSuccessful = taxTransferer.transferTaxFor(person);

		// then
		assertThat(transferSuccessful, is(true));
		verify(taxService).transferTaxFor(person);
	}

}

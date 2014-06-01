package com.blogspot.toomuchcoding.book.chapter6._6_VerifyingInOrder;

import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class TaxUpdaterTest {

    @Mock TaxService taxService;

    @InjectMocks TaxUpdater systemUnderTest;

    @Test
    public void should_update_tax_factor_and_transfer_tax_in_specified_order() {
        // given
        Person person = new Person();

        // when
        systemUnderTest.transferTaxFor(person);

        // then
        InOrder inOrder = Mockito.inOrder(taxService);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService, times(2)).transferTaxFor(person);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService).transferTaxFor(person);
    }
	
    @Test
    public void should_transfer_tax_in_specified_order() {
        // given
        Person person = new Person();

        // when
        systemUnderTest.transferTaxFor(person);

        // then
        InOrder inOrder = Mockito.inOrder(taxService);
	    inOrder.verify(taxService, times(2)).transferTaxFor(person);
	    inOrder.verify(taxService).transferTaxFor(person);
    }
	
    @Test
    public void should_update_tax_factor_and_transfer_tax_in_specified_order_with_less_calls() {
        // given
        Person person = new Person();

        // when
        systemUnderTest.transferTaxFor(person);

        // then
        InOrder inOrder = Mockito.inOrder(taxService);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService, calls(1)).transferTaxFor(person);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService).transferTaxFor(person);
    }
	
    @Test
    public void should_update_tax_factor_and_transfer_tax_in_specified_order_with_calls() {
        // given
        Person person = new Person();

        // when
        systemUnderTest.transferTaxFor(person);

        // then
        InOrder inOrder = Mockito.inOrder(taxService);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService, calls(2)).transferTaxFor(person);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService).transferTaxFor(person);
    }
	
}

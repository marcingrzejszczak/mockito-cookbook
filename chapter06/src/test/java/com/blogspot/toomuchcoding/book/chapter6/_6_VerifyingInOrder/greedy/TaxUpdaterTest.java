package com.blogspot.toomuchcoding.book.chapter6._6_VerifyingInOrder.greedy;

import com.blogspot.toomuchcoding.book.chapter6._6_VerifyingInOrder.TaxService;
import com.blogspot.toomuchcoding.book.chapter6._6_VerifyingInOrder.TaxUpdater;
import com.blogspot.toomuchcoding.person.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.VerificationInOrderFailure;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;

@RunWith(MockitoJUnitRunner.class)
public class TaxUpdaterTest {

    @Mock TaxService taxService;

    @InjectMocks TaxUpdater systemUnderTest;

    @Test
    public void should_fail_at_updating_tax_factor_and_transfer_tax_in_specified_order_due_to_greedy_at_least() throws Exception {
        // given
        Person person = new Person();

        // when
        systemUnderTest.transferTaxFor(person);

        // then
        InOrder inOrder = Mockito.inOrder(taxService);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService, atLeastOnce()).transferTaxFor(person);
        try {
            inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
            inOrder.verify(taxService).transferTaxFor(person);
        } catch (VerificationInOrderFailure verificationInOrderFailure) {}

    }

    /** Expected added only for the test to pass **/
    @Test(expected = VerificationInOrderFailure.class)
    public void should_fail_at_updating_second_tax_factor_in_specified_order_due_to_greedy_at_least() throws Exception {
        // given
        Person person = new Person();

        // when
        systemUnderTest.transferTaxFor(person);

        // then
        InOrder inOrder = Mockito.inOrder(taxService);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService, atLeastOnce()).transferTaxFor(person);
        inOrder.verify(taxService).updateTaxFactor(eq(person), anyDouble());
        inOrder.verify(taxService).transferTaxFor(person);
    }
}

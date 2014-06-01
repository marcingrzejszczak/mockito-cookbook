package com.blogspot.toomuchcoding.book.chapter10._4_Spock
import com.blogspot.toomuchcoding.book.chapter10.TaxService
import com.blogspot.toomuchcoding.book.chapter10.TaxTransferer
import com.blogspot.toomuchcoding.person.Person
import spock.lang.Specification
import spock.lang.Unroll

import static org.hamcrest.Matchers.equalTo
import static spock.util.matcher.HamcrestSupport.*

class TaxTransferrerSpec extends Specification {

    TaxService taxService = Mock()

    TaxTransferer systemUnderTest = new TaxTransferer(taxService);

    def 'should return false when tax was not transfered and connection to irs was refused'() {
        given:
            Person person = new Person()
        when:
            boolean transferSuccessful = systemUnderTest.transferTaxFor(person)
        then:
            !transferSuccessful
            1 * taxService.hasAlreadyTransferredTax(person) >> false
            1 * taxService.transferTaxFor(person) >> { throw new RuntimeException("Connection refused") }

    }

    def 'should return false when tax was not transfered and connection to irs was refused (using Hamcrest)'() {
        given:
            Person person = new Person()
        when:
            boolean transferSuccessful = systemUnderTest.transferTaxFor(person)
        then:
            expect transferSuccessful, equalTo(false)
            1 * taxService.hasAlreadyTransferredTax(person) >> false
            1 * taxService.transferTaxFor(person) >> { throw new RuntimeException("Connection refused") }

    }
    
    @Unroll
    def "should return [#transferSuccessful] when tax was already transferred [#alreadyTransferredTax] and connection to irs was refused [#throwsException]"() {
        given:
            Person person = new Person()
        when:
            boolean transferSuccessfulResult = systemUnderTest.transferTaxFor(person)
        then:
            transferSuccessfulResult == transferSuccessful 
            hasAlreadyTransferredTaxCount * taxService.hasAlreadyTransferredTax(person) >> alreadyTransferredTax
            transferTaxForCount * taxService.transferTaxFor(person) >> { if(throwsException) { throw new RuntimeException("Connection refused") } }
        where:
            alreadyTransferredTax | throwsException || hasAlreadyTransferredTaxCount | transferTaxForCount | transferSuccessful
            true                  | false           || 1                             | 0                   | false
            false                 | false           || 1                             | 1                   | true
            false                 | true            || 1                             | 1                   | false

    }

    @Unroll
    def "should return [#transferSuccessful] when tax wasn't already transferred and connection to irs was refused [#throwsException]"() {
        given:
            Person person = new Person()
        when:
            boolean transferSuccessfulResult = systemUnderTest.transferTaxFor(person)
        then:
            transferSuccessfulResult == transferSuccessful
            1 * taxService.hasAlreadyTransferredTax(person) >> false
            1 * taxService.transferTaxFor(person) >> { if(throwsException) { throw new RuntimeException("Connection refused") } }
        where:
            throwsException || transferSuccessful
            true            || false
            false           || true

    }

}

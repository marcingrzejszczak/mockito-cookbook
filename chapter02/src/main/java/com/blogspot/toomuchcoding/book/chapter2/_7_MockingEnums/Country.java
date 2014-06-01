package com.blogspot.toomuchcoding.book.chapter2._7_MockingEnums;

import com.blogspot.toomuchcoding.person.Person;

public enum Country implements TaxRateCalculator {
    POLAND {
        @Override
        public double calculateTaxFactorFor(Person person) {
            return new PolishWebService().doLongOperation(person);
        }
    },
    OTHER {
        @Override
        public double calculateTaxFactorFor(Person person) {
            return new OtherWebService().doLongOperation(person);
        }
    };

    public static Country fromCountryName(String countryName){
        if(POLAND.name().equalsIgnoreCase(countryName)){
            return POLAND;
        }
        return OTHER;
    }
}

interface TaxRateCalculator {
    double calculateTaxFactorFor(Person person);
}

class PolishWebService {
    double doLongOperation(Person person) {
        return 1;
    }
}

class OtherWebService {
    double doLongOperation(Person person) {
        return 0;
    }
}
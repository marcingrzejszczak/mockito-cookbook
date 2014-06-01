package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import java.util.Date;

public class BadlyDesignedVisitLogger {

    public Date logUsersVisit(){
        Date dateOfLogging = new Date();
        System.out.printf("User visited us at [%s]%n", dateOfLogging);
        return dateOfLogging;
    }

}

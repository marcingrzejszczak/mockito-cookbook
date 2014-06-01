package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import java.util.Date;

public class RefactoredVisitLogger {

    private final TimeSource timeSource;

    public RefactoredVisitLogger(TimeSource timeSource) {
        this.timeSource = timeSource;
    }

    public Date logUsersVisit(){
        Date dateOfLogging = timeSource.getDate();
        System.out.printf("User visited us at [%s]%n", dateOfLogging);
        return dateOfLogging;
    }

}



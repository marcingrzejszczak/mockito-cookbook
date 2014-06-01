package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import static org.assertj.core.api.BDDAssertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VisitLoggerTest {

    @Mock TimeSource timeSource;

    @InjectMocks RefactoredVisitLogger refactoredVisitLogger;

    @Test
    public void should_return_users_logging_time() {
        // given
        Date currentDate = TimeSource.on("01-06-2014");
        given(timeSource.getDate()).willReturn(currentDate);

        // when
        Date dateOfLogging = refactoredVisitLogger.logUsersVisit();

        // then
        then(dateOfLogging).isSameAs(currentDate);
    }

}

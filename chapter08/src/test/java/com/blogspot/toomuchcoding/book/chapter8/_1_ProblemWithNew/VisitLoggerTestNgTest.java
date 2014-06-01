package com.blogspot.toomuchcoding.book.chapter8._1_ProblemWithNew;

import com.blogspot.toomuchcoding.common.testng.MockitoTestNGListener;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Date;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@Listeners(MockitoTestNGListener.class)
public class VisitLoggerTestNgTest {

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

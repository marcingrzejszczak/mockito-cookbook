package com.blogspot.toomuchcoding.book.chapter9.InjectingWithSpringComponentScan;

import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;

@Configuration
class MockTaxConfiguration {
    /*
    Uncomment only to see that it is not working - check the logs

    @Bean
    public TaxService taxService() {
        return Mockito.mock(TaxService.class);
    }*/

    @Bean
    public BeanPostProcessor taxServiceBeanPostProcessor() {
        return new BeanPostProcessor(){

            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if(bean instanceof TaxService) {
                    return Mockito.mock(TaxService.class);
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }
        };
    }

}

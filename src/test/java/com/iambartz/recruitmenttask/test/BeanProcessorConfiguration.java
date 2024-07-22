package com.iambartz.recruitmenttask.test;

import com.iambartz.recruitmenttask.test.mock.MockWrappedBeanResetBeanProcessor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
class BeanProcessorConfiguration {

    @Bean
    MockWrappedBeanResetBeanProcessor mockWrappedBeanResetBeanProcessor() {
        return new MockWrappedBeanResetBeanProcessor();
    }
}

package com.iambartz.recruitmenttask.test;

import com.iambartz.recruitmenttask.RecruitmentTaskApplication;
import com.iambartz.recruitmenttask.test.mock.MockWrappedBeanResetTestExecutionListener;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Explanation: <a href="https://filip-prochazka.com/blog/mockbean-is-an-anti-pattern" />
 */
@SpringBootTest(classes = {
        RecruitmentTaskApplication.class,
        TestBeanConfiguration.class,
        BeanProcessorConfiguration.class
})
@TestExecutionListeners(listeners = {
        DependencyInjectionTestExecutionListener.class,
        MockWrappedBeanResetTestExecutionListener.class
})
@AutoConfigureMockMvc
public abstract class AbstractTest {
}

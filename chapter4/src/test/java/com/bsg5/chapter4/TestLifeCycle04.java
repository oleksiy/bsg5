package com.bsg5.chapter4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

class FourthObject extends HasData implements InitializingBean, DisposableBean {
    static Object semaphore = null;


    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        semaphore = null;
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        semaphore = new Object();
    }
}

@ContextConfiguration(locations = "/config-04.xml")
public class TestLifeCycle04 extends AbstractTestNGSpringContextTests {
    @Autowired
    ConfigurableApplicationContext context;

    @Test
    public void testLifecycleMethods() {
        FourthObject o1 = context.getBean(FourthObject.class);
        assertNotNull(FourthObject.semaphore);
        assertEquals(o1.getDatum(), "default");
        context.close();
        assertNull(FourthObject.semaphore);
    }
}

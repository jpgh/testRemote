package com.example.demo;

import org.jmock.lib.concurrent.Blitzer;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private TestService testService;
    @Autowired
    private TestSingletonBean testSingletonBean;

    private Blitzer blitzer = new Blitzer(500, 50);

    @After
    public void tearDown() {
        blitzer.shutdown();
    }

    @Test
    public void test() throws InterruptedException {
        blitzer.blitz(() -> testSingletonBean.doJob());

        assertThat("final count",
                testSingletonBean.count(),
                equalTo(blitzer.totalActionCount()));
    }

    @Test
    public void test_Sync() throws InterruptedException {
        blitzer.blitz(() -> testSingletonBean.doJobSync());

        assertThat("final count",
                testSingletonBean.count(),
                equalTo(blitzer.totalActionCount()));
    }

//    @Test
//    public void deadLock() throws InterruptedException {
//        new Thread(() -> {
//            System.out.println("start1");
//            testSingletonBean.doJobSync();}).start();
//        new Thread(() -> {
//            System.out.println("start2");
//            testSingletonBean.doJobSync2();}).start();
//        Thread.sleep(5000);
//    }

}

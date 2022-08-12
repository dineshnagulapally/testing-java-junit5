package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {
    IndexController indexController;
    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    @DisplayName("Test proper  view name is returned for index page")
    void index() {
        assertEquals("index",indexController.index());
        assertEquals("index",indexController.index(),"Wrong name");
    }

    @Test
    @DisplayName("Test exception")//Runs in single thread so
    void oupsHandler() {
//        assertTrue("notimplemented".equals(indexController.oupsHandler()),()->"this is expensive msg");
        assertThrows(ValueNotFoundException.class,()->{
            indexController.oupsHandler();
        });
    }

    @Test//Runs in single thread so it runs the supplier irrespective of timeout
    void timeoutTest(){
        assertTimeout(Duration.ofMillis(100),
                ()->{
            Thread.sleep(2000);
                    System.out.println("I am here");
                });
    }
    @Test//Runs in different thread , obe=serve test exec time
    void timeoutTestPreempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100),
                ()->{
                    Thread.sleep(2000);
                    System.out.println("I am here fdgsfhg");
                });
    }
}
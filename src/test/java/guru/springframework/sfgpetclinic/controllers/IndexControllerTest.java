package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test exception")//Runs in single thread so
    void oupsHandler() {
//        assertTrue("notimplemented".equals(indexController.oupsHandler()),()->"this is expensive msg");
        assertThrows(ValueNotFoundException.class,()->{
            indexController.oupsHandler();
        });
    }
@Disabled
    @Test//Runs in single thread so it runs the supplier irrespective of timeout
    void timeoutTest(){
        assertTimeout(Duration.ofMillis(100),
                ()->{
            Thread.sleep(2000);
                    System.out.println("I am here");
                });
    }
    @Disabled
    @Test//Runs in different thread , obe=serve test exec time
    void timeoutTestPreempt(){
        assertTimeoutPreemptively(Duration.ofMillis(100),
                ()->{
                    Thread.sleep(2000);
                    System.out.println("I am here fdgsfhg");
                });
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testOnMacOs(){

    }
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnWindows(){

    }
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testOnJava8(){

    }
    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testOnJava11(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER",matches = "dines")
    void testIfUserFred(){

    }
}
package guru.springframework;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@Tag("controller")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//it will not be able to run the test case in this interface unless we make it @TestInstance
public interface Controller {

    @BeforeAll
    default void beforeAll(){
        System.out.println("before all");
    }
}

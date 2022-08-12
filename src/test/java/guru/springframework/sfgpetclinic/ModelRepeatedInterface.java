package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;

@Tag("repeated")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelRepeatedInterface {
    @BeforeAll
    default void RepeatedHomeWork(TestInfo testInfo/*, RepetitionInfo repetitionInfo*/){
        System.out.println(testInfo.getDisplayName());
    }
}

package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTest implements ModelRepeatedInterface {
    @org.junit.jupiter.api.RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} out of {totalRepetitions}")
    @DisplayName("My Repitition")
    void repetitionTest(){
        System.out.println("repeat sometimes");
    }

    @org.junit.jupiter.api.RepeatedTest(5)
    void myRepeatedTestUsingDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getDisplayName()+" : "+ repetitionInfo.getCurrentRepetition());
    }

    @org.junit.jupiter.api.RepeatedTest(value = 5,name = "{displayName} : {currentRepetition} out of {totalRepetitions}")
    @DisplayName("My HomeWork Test")
    void RepeatedTestHomeWork(){
        System.out.println("");
    }
}

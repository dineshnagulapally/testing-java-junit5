package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelInterface {

    @Test
    void groupedAssertion(){
        //given
        Person person = new Person(1l,"Joe","Buck");

        //then
        assertAll("Test prop set",
                ()->assertEquals("Joe",person.getFirstName()),
                ()->assertEquals("Buck",person.getLastName())
                );
    }

    @Test
    void groupedAssertionFail(){
        //given
        Person person = new Person(1l,"Joe","Buck");

        //then
        assertAll("Test prop set",
                ()->assertEquals("Joe",person.getFirstName(),"First name is not valid"),
                ()->assertEquals("Buck",person.getLastName())
        );
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} out of {totalRepetitions}")
    @DisplayName("My Repitition")
    void repetitionTest(){
        System.out.println("repeat sometimes");
    }
}
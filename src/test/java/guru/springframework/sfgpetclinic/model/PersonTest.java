package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelInterface;
import org.junit.jupiter.api.*;

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


}
package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssert(){
        Owner owner = new Owner(1l,"Joe","Buck");
        owner.setCity("Key West");
        owner.setTelephone("123123464");

        assertAll("Prop test",
                ()->{
                    assertAll("Person props"
                    ,
                            ()->assertEquals("Joea",owner.getFirstName(),"First name issue"),
                            ()->assertEquals("Buck",owner.getLastName())
                    );
                },
                ()->{
                assertAll("Owner props",
                        ()->assertEquals("Key Westa",owner.getCity(),"City issue"),
                        ()->assertEquals("123123464",owner.getTelephone())
                        );
                }
        );
    }
}
package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelInterface;
import guru.springframework.sfgpetclinic.controllers.OwnerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelInterface {

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
        assertThat(owner.getCity(),is("Key West"));
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @DisplayName("Value Source")
    @ValueSource(strings = {"Spring", "Framework"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @DisplayName("Enum Source")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @DisplayName("CSV test source")
    @CsvSource({
            "MO,1,1",
            "MA,2,2"
    })
    void csvSource(String state,int v1, int v2){
        System.out.println(state + " - "+ v1+" "+v2);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @DisplayName("CS file source")
    @CsvFileSource(resources = "/inp.csv",numLinesToSkip = 1)
    void csvTestFileSource(String state, int v1, int v2){
        System.out.println(state+" "+v1+" "+v2);
    }
}
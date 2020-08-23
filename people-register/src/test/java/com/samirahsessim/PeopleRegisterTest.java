package com.samirahsessim;

import com.samirahsessim.exception.EmptyRegisterException;
import com.samirahsessim.exception.PersonWithoutNameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PeopleRegisterTest {

    @Test
    public void createRegister() {
        PeopleRegister register = new PeopleRegister();
        Assertions.assertThat(register.getPeople()).isEmpty();
    }

    @Test
    public void add_whenIsCalled_shouldAddPeopleToRegister() throws PersonWithoutNameException {
        PeopleRegister register = new PeopleRegister();
        Person person = new Person();
        person.setName("NAME");
        register.add(person);

        Assertions.assertThat(register.getPeople())
                .isNotEmpty()
                .hasSize(1)
                .contains(person);
    }

    @Test
    public void when_personWithoutName_shouldThrowsPersonWithoutNameException() {
        PeopleRegister register = new PeopleRegister();
        Person person = new Person();

        assertThrows(PersonWithoutNameException.class, () -> register.add(person));
    }

    @Test
    public void remove_whenIsCalled_shouldRemovePerson() throws PersonWithoutNameException {
        PeopleRegister register = new PeopleRegister();
        Person person = new Person();
        person.setName("NAME");
        register.add(person);

        register.remove(person);

        Assertions.assertThat(register.getPeople()).isEmpty();

    }

    @Test
    public void when_tryToRemoveUnexistentPeople_shouldThrowsEmptyRegisterException() {
        PeopleRegister register = new PeopleRegister();
        Person person = new Person();
        assertThrows(EmptyRegisterException.class, () -> register.remove(person));
    }
}

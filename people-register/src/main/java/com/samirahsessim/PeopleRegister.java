package com.samirahsessim;

import com.samirahsessim.exception.EmptyRegisterException;
import com.samirahsessim.exception.PersonWithoutNameException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class PeopleRegister {
    private List<Person> people;

    public PeopleRegister() {
        this.people = new ArrayList<>();
    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void add(Person person) throws PersonWithoutNameException {
        if (isNull(person.getName())) {
            throw new PersonWithoutNameException();
        }
        this.people.add(person);
    }

    public void remove(Person person) {
        if (!this.people.contains(person)) {
            throw new EmptyRegisterException();
        }
        this.people.remove(person);
    }
}
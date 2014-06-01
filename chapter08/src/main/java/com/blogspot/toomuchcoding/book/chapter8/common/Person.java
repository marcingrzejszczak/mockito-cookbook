package com.blogspot.toomuchcoding.book.chapter8.common;

import static java.util.Arrays.*;

import java.util.List;

public class Person {
    private final String name;
    private final int age;
    private final List<Person> siblings;

    public Person(String name, int age, List<Person> siblings) {
        this.name = name;
        this.age = age;
        this.siblings = siblings;
    }

    public Person(String name) {
        this.name = name;
        this.age = 20;
        this.siblings = asList();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.siblings = asList();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (siblings != null ? !siblings.equals(person.siblings) : person.siblings != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (siblings != null ? siblings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", siblings=").append(siblings);
        sb.append('}');
        return sb.toString();
    }
}

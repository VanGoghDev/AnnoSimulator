package ru.firsov.kirill.DB;

public class BDApp {

    public static void main(String[] args) {
        Person p = new Person(11, "Vadim", 21, 40.50f);

        PersonRepository repository = new PersonRepository();
        repository.insert(p);
    }

}

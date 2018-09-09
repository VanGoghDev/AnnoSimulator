package ru.firsov.kirill.DB;

public class BDApp {

    public static void main(String[] args) {
        Person p = new Person(12, "Kirill", 21, 23f);

        PersonRepository repository = new PersonRepository();
        repository.insert(p);
    }

}

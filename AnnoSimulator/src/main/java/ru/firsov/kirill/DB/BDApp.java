package ru.firsov.kirill.DB;

public class BDApp {

    public static void main(String[] args) {
        Person p = new Person(11, "Vadim", 21, 40.50f);
        Person p2 = new Person(12, "Kirill", 21, 23f);

        PersonRepository repository = new PersonRepository();
        repository.insert(p);
        repository.insert(p2);
    }

}

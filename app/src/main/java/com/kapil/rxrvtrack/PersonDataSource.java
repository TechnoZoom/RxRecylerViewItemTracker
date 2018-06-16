package com.kapil.rxrvtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kapilbakshi on 16/06/18.
 */

public class PersonDataSource {

    public static final String PERSON_NAME = "Person Name ";
    public static final String PERSON_NO = "Person No ";

    public static PersonDataSource newInstance() {

        return new PersonDataSource();
    }

    public List<Person> getRandomPersonsList(int noOfEntries) {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= noOfEntries; i++) {
            personList.add(new Person(PERSON_NAME + i, PERSON_NO + i));
        }
        return personList;
    }

}

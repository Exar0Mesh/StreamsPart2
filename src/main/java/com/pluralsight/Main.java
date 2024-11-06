package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = getSearch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What name would you like to search?: ");
        System.out.println("input a first or last name");
        String search = scanner.nextLine();

        people.stream()
                .filter(person -> search.contains(person.firstName))
                .forEach(person -> System.out.println
                        (person.getFirstName() + ", " + person.getLastName() + ", " + person.getAge()));

        people.stream()
                .filter(person -> search.contains(person.lastName))
                .forEach(person -> System.out.println
                        (person.getFirstName() + ", " + person.getLastName() + ", " + person.getAge()));

        double average = people.stream()
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0.0);
        if (search.equalsIgnoreCase("average")) {
            System.out.println(average);
        }

        /*
        int sum = people.stream()
                .filter(person -> search.contains("average"))
                .map(num -> num.age)
                .reduce(0, (temp, num)-> temp += num);
        System.out.println(sum);
                                        Useful for later maybe
         */
    }

    public static ArrayList<Person> getSearch() {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Olivia", "Mitchell", 23));     //1
        people.add(new Person("Samuel", "Turner", 25));       //2
        people.add(new Person("Isabella", "Clark", 40));      //3
        people.add(new Person("Ethan", "Davis", 18));         //4
        people.add(new Person("Ava", "Thompson", 23));        //5
        people.add(new Person("James", "Richardson", 33));    //6
        people.add(new Person("Mia", "Bennett", 26));         //7
        people.add(new Person("Lucas", "Anderson", 24));      //8
        people.add(new Person("Charlotte", "Evans", 30));     //9
        people.add(new Person("Benjamin", "Harris", 32));
        return people;
    }
}
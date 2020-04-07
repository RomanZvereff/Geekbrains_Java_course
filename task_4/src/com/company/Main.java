package com.company;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Bob", "CEO", "bob_barton@gmail.com", "0981122777", 12000, 31);
        employees[1] = new Employee("Sarah", "HR", "sarah_conor@gmail.com", "0739988732", 5000, 23);
        employees[2] = new Employee("Will", "Designer", "will_smith@gmail.com", "0661122321", 8000, 27);
        employees[3] = new Employee("Nick", "Guard", "nick_fury@gmail.com", "0661234567", 7500, 45);
        employees[4] = new Employee("Steve", "Developer", "steve_rogers@gmail.com", "0977654321", 10000, 21);

        for (int i = 0; i < employees.length; i++) {
            if(employees[i].age > 40) {
                System.out.println(employees[i].toString());
            }
        }

        Cat cat = new Cat();
        cat.swim();

        Dog dog = new Dog();
        dog.run(250);
    }
}

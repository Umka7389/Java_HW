package ru.geekbrains.HW.Java_HW;

public class Homework_4 {

    public static void main (String[] args){
        int minAgePrint = 40;
        int minAgeRise = 45;
        int bonus = 5000;
        int averageSalary = 0;
        int averageAge = 0;

        Employee.employeeQuantity = 5;
        Employee a = new Employee("Петров И.И.", 150000, 30);
        System.out.println("ФИО: " + a.getName() + "\nВозраст: " + a.getAge()
        );

        System.out.println("--------------------------------");

        Employee [] employees = new Employee[Employee.employeeQuantity];
        employees [0] = a;
        employees [1] = new Employee("Иванов И.И.", 120000, 40);
        employees [2] = new Employee("Сидоров И.И.", 130000, 32);
        employees [3] = new Employee("Рыжков И.И.", 200000, 46);
        employees [4] = new Employee("Мухин И.И.", 180000, 39);

        System.out.println("Cотрудники старше " + minAgePrint + " лет:");
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getAge() > minAgePrint){
                System.out.println(employees[i].getName());
            }
        }

        System.out.println("--------------------------------");

        for (int i = 0; i < employees.length; i++){
            employees[i].riseSalary(employees[i].getAge(), minAgeRise, bonus);
        }
        System.out.println(employees[3].getSalary());

            System.out.println("--------------------------------");

        for (int i = 0; i < employees.length; i++){
            averageAge += employees[i].getAge();
            averageSalary += employees[i].getSalary();
        }
        averageAge = averageAge / employees.length;
        averageSalary = averageSalary / employees.length;
        System.out.println(averageAge);
        System.out.println(averageSalary);

        System.out.println("--------------------------------");

        System.out.println(employees[0].getId());

    }
}

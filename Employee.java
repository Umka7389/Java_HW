package ru.geekbrains.HW.Java_HW;

public class Employee {
    private String name;
    private int salary;
    private int age;
    public static int employeeQuantity;
    private int id = 0;
    private static int idCount = 1;

    Employee (String n, int s, int a) {
       name = n;
       salary = s;
       age = a;
       id = idCount++;
    }
    public String getName () {
        return name;
    }
    public int getSalary () {
        return salary;
    }
    public int getAge () {
        return age;
    }
    public void setSalaryUp (int bonus) {
        salary = salary + bonus;
    }
    public int getId () {
        return id;
    }
    public void riseSalary(int ageEmployee, int minAgeRise,int bonus){
            if (ageEmployee > minAgeRise) {
                setSalaryUp(bonus);
            }
    }
}

package ru.geekbrains.HW.Java_HW;

public class Main {
    public static void main(String[] args) {
        int runDistance = 150;
        int swimDistance = 100;
        float jumpHeight = 0.5f;

        Dog dog1 = new Dog(100,10,0.5f);
        dog1.run(runDistance);
        dog1.swim(swimDistance);
        dog1.jump(jumpHeight);

        System.out.println("-----------");

        Dog dog2 = new Dog();
        dog2.run(runDistance);
        dog2.swim(swimDistance);
        dog2.jump(jumpHeight);

        System.out.println("-----------");
        Cat cat1 = new Cat(200,2);
        cat1.run(runDistance);
        cat1.swim(swimDistance);
        cat1.jump(jumpHeight);

        System.out.println("-----------");

        Horse horse1 = new Horse(1500,100,3);
        horse1.run(runDistance);
        horse1.swim(swimDistance);
        horse1.jump(jumpHeight);

        System.out.println("-----------");

        Bird bird1 = new Bird(5,0.2f);
        bird1.run(runDistance);
        bird1.swim(swimDistance);
        bird1.jump(jumpHeight);

    }

}

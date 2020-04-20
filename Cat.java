package ru.geekbrains.HW.Java_HW;

public class Cat extends Animal {
    private int maxRunDistance = 200;
    private float maxJumpHeight = 2f;

    Cat(){}

    Cat (int maxRunDistance, float maxJumpHeight){
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    protected void run (int distance){
        if (distance <= maxRunDistance) {
            System.out.println("Кошка пробежала - " + distance + " м!");
        } else System.out.println("Кошка не добежала!");
    }
    @Override
    protected void swim (int distance){
            System.out.println("Кошки не плавают!");
    }
    @Override
    protected void jump (float height){
        if (height <= maxJumpHeight) {
            System.out.println("Кошка прыгнула на - " + height + " м!");
        } else System.out.println("Кошка не перепрыгнула!");
    }

}
